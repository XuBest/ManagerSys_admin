<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="报名用户ID" prop="UserId">
        <el-input
          v-model="queryParams.UserId"
          placeholder="请输入报名用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动ID" prop="EventId">
        <el-input
          v-model="queryParams.EventId"
          placeholder="请输入活动ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['ActivitySys:registrations:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['ActivitySys:registrations:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['ActivitySys:registrations:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ActivitySys:registrations:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="registrationsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="报名信息ID" align="center" prop="RegId" />
      <el-table-column label="报名用户ID" align="center" prop="UserId" />
      <el-table-column label="活动ID" align="center" prop="EventId" />
      <el-table-column label="报名信息状态" align="center" prop="RegStatus" />
      <el-table-column label="报名时间" align="center" prop="RegTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.RegTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['ActivitySys:registrations:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ActivitySys:registrations:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改报名信息管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="报名用户ID" prop="UserId">
          <el-input v-model="form.UserId" placeholder="请输入报名用户ID" />
        </el-form-item>
        <el-form-item label="活动ID" prop="EventId">
          <el-input v-model="form.EventId" placeholder="请输入活动ID" />
        </el-form-item>
        <el-form-item label="报名时间" prop="RegTime">
          <el-date-picker clearable
            v-model="form.RegTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择报名时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRegistrations, getRegistrations, delRegistrations, addRegistrations, updateRegistrations } from "@/api/ActivitySys/registrations";

export default {
  name: "Registrations",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 报名信息管理表格数据
      registrationsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        UserId: null,
        EventId: null,
        RegStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        UserId: [
          { required: true, message: "报名用户ID不能为空", trigger: "blur" }
        ],
        EventId: [
          { required: true, message: "活动ID不能为空", trigger: "blur" }
        ],
        RegTime: [
          { required: true, message: "报名时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询报名信息管理列表 */
    getList() {
      this.loading = true;
      listRegistrations(this.queryParams).then(response => {
        this.registrationsList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        RegId: null,
        UserId: null,
        EventId: null,
        RegStatus: null,
        RegTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.RegId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加报名信息管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const RegId = row.RegId || this.ids
      getRegistrations(RegId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改报名信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.RegId != null) {
            updateRegistrations(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRegistrations(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const RegIds = row.RegId || this.ids;
      this.$modal.confirm('是否确认删除报名信息管理编号为"' + RegIds + '"的数据项？').then(function() {
        return delRegistrations(RegIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ActivitySys/registrations/export', {
        ...this.queryParams
      }, `registrations_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
