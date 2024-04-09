package com.ruoyi.ActivitySys.controller;

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
import com.ruoyi.ActivitySys.domain.Registrations;
import com.ruoyi.ActivitySys.service.IRegistrationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报名信息管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@RestController
@RequestMapping("/ActivitySys/registrations")
public class RegistrationsController extends BaseController
{
    @Autowired
    private IRegistrationsService registrationsService;

    /**
     * 查询报名信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:registrations:list')")
    @GetMapping("/list")
    public TableDataInfo list(Registrations registrations)
    {
        startPage();
        List<Registrations> list = registrationsService.selectRegistrationsList(registrations);
        return getDataTable(list);
    }

    /**
     * 导出报名信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:registrations:export')")
    @Log(title = "报名信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Registrations registrations)
    {
        List<Registrations> list = registrationsService.selectRegistrationsList(registrations);
        ExcelUtil<Registrations> util = new ExcelUtil<Registrations>(Registrations.class);
        util.exportExcel(response, list, "报名信息管理数据");
    }

    /**
     * 获取报名信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:registrations:query')")
    @GetMapping(value = "/{RegId}")
    public AjaxResult getInfo(@PathVariable("RegId") Integer RegId)
    {
        return success(registrationsService.selectRegistrationsByRegId(RegId));
    }

    /**
     * 新增报名信息管理
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:registrations:add')")
    @Log(title = "报名信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Registrations registrations)
    {
        return toAjax(registrationsService.insertRegistrations(registrations));
    }

    /**
     * 修改报名信息管理
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:registrations:edit')")
    @Log(title = "报名信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Registrations registrations)
    {
        return toAjax(registrationsService.updateRegistrations(registrations));
    }

    /**
     * 删除报名信息管理
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:registrations:remove')")
    @Log(title = "报名信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{RegIds}")
    public AjaxResult remove(@PathVariable Integer[] RegIds)
    {
        return toAjax(registrationsService.deleteRegistrationsByRegIds(RegIds));
    }
}
