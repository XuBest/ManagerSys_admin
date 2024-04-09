package com.ruoyi.PeopleSys.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.PeopleSys.domain.Employees;
import com.ruoyi.PeopleSys.service.IEmployeesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 职工信息管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@RestController
@RequestMapping("/PeopleSys/employees")
public class EmployeesController extends BaseController
{
    @Autowired
    private IEmployeesService employeesService;

    /**
     * 查询职工信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('PeopleSys:employees:list')")
    @GetMapping("/list")
    public TableDataInfo list(Employees employees)
    {
        startPage();
        List<Employees> list = employeesService.selectEmployeesList(employees);
        return getDataTable(list);
    }

    /**
     * 导出职工信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('PeopleSys:employees:export')")
    @Log(title = "职工信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Employees employees)
    {
        List<Employees> list = employeesService.selectEmployeesList(employees);
        ExcelUtil<Employees> util = new ExcelUtil<Employees>(Employees.class);
        util.exportExcel(response, list, "职工信息管理数据");
    }

    /**
     * 获取职工信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('PeopleSys:employees:query')")
    @GetMapping(value = "/{EmployeeId}")
    public AjaxResult getInfo(@PathVariable("EmployeeId") Integer EmployeeId)
    {
        return success(employeesService.selectEmployeesByEmployeeId(EmployeeId));
    }

    /**
     * 新增职工信息管理
     */
    @PreAuthorize("@ss.hasPermi('PeopleSys:employees:add')")
    @Log(title = "职工信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Employees employees)
    {
        return toAjax(employeesService.insertEmployees(employees));
    }

    /**
     * 修改职工信息管理
     */
    @PreAuthorize("@ss.hasPermi('PeopleSys:employees:edit')")
    @Log(title = "职工信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Employees employees)
    {
        return toAjax(employeesService.updateEmployees(employees));
    }

    /**
     * 删除职工信息管理
     */
    @PreAuthorize("@ss.hasPermi('PeopleSys:employees:remove')")
    @Log(title = "职工信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{EmployeeIds}")
    public AjaxResult remove(@PathVariable Integer[] EmployeeIds)
    {
        return toAjax(employeesService.deleteEmployeesByEmployeeIds(EmployeeIds));
    }
}
