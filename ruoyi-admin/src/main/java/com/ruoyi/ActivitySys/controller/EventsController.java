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
import com.ruoyi.ActivitySys.domain.Events;
import com.ruoyi.ActivitySys.service.IEventsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动发布管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@RestController
@RequestMapping("/ActivitySys/events")
public class EventsController extends BaseController
{
    @Autowired
    private IEventsService eventsService;

    /**
     * 查询活动发布管理列表
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:events:list')")
    @GetMapping("/list")
    public TableDataInfo list(Events events)
    {
        startPage();
        List<Events> list = eventsService.selectEventsList(events);
        return getDataTable(list);
    }

    /**
     * 导出活动发布管理列表
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:events:export')")
    @Log(title = "活动发布管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Events events)
    {
        List<Events> list = eventsService.selectEventsList(events);
        ExcelUtil<Events> util = new ExcelUtil<Events>(Events.class);
        util.exportExcel(response, list, "活动发布管理数据");
    }

    /**
     * 获取活动发布管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:events:query')")
    @GetMapping(value = "/{EventId}")
    public AjaxResult getInfo(@PathVariable("EventId") Integer EventId)
    {
        return success(eventsService.selectEventsByEventId(EventId));
    }

    /**
     * 新增活动发布管理
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:events:add')")
    @Log(title = "活动发布管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Events events)
    {
        return toAjax(eventsService.insertEvents(events));
    }

    /**
     * 修改活动发布管理
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:events:edit')")
    @Log(title = "活动发布管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Events events)
    {
        return toAjax(eventsService.updateEvents(events));
    }

    /**
     * 删除活动发布管理
     */
    @PreAuthorize("@ss.hasPermi('ActivitySys:events:remove')")
    @Log(title = "活动发布管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{EventIds}")
    public AjaxResult remove(@PathVariable Integer[] EventIds)
    {
        return toAjax(eventsService.deleteEventsByEventIds(EventIds));
    }
}
