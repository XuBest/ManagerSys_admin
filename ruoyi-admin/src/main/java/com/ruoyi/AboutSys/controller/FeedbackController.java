package com.ruoyi.AboutSys.controller;

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
import com.ruoyi.AboutSys.domain.Feedback;
import com.ruoyi.AboutSys.service.IFeedbackService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户反馈管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@RestController
@RequestMapping("/AboutSys/feedback")
public class FeedbackController extends BaseController
{
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * 查询用户反馈管理列表
     */
    @PreAuthorize("@ss.hasPermi('AboutSys:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(Feedback feedback)
    {
        startPage();
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        return getDataTable(list);
    }

    /**
     * 导出用户反馈管理列表
     */
    @PreAuthorize("@ss.hasPermi('AboutSys:feedback:export')")
    @Log(title = "用户反馈管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Feedback feedback)
    {
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        ExcelUtil<Feedback> util = new ExcelUtil<Feedback>(Feedback.class);
        util.exportExcel(response, list, "用户反馈管理数据");
    }

    /**
     * 获取用户反馈管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('AboutSys:feedback:query')")
    @GetMapping(value = "/{fbId}")
    public AjaxResult getInfo(@PathVariable("fbId") Integer fbId)
    {
        return success(feedbackService.selectFeedbackByFbId(fbId));
    }

    /**
     * 新增用户反馈管理
     */
    @PreAuthorize("@ss.hasPermi('AboutSys:feedback:add')")
    @Log(title = "用户反馈管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.insertFeedback(feedback));
    }

    /**
     * 修改用户反馈管理
     */
    @PreAuthorize("@ss.hasPermi('AboutSys:feedback:edit')")
    @Log(title = "用户反馈管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.updateFeedback(feedback));
    }

    /**
     * 删除用户反馈管理
     */
    @PreAuthorize("@ss.hasPermi('AboutSys:feedback:remove')")
    @Log(title = "用户反馈管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fbIds}")
    public AjaxResult remove(@PathVariable Integer[] fbIds)
    {
        return toAjax(feedbackService.deleteFeedbackByFbIds(fbIds));
    }
}
