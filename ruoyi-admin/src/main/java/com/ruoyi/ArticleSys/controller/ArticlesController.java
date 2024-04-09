package com.ruoyi.ArticleSys.controller;

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
import com.ruoyi.ArticleSys.domain.Articles;
import com.ruoyi.ArticleSys.service.IArticlesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告宣传管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@RestController
@RequestMapping("/ArticleSys/articles")
public class ArticlesController extends BaseController
{
    @Autowired
    private IArticlesService articlesService;

    /**
     * 查询公告宣传管理列表
     */
    @PreAuthorize("@ss.hasPermi('ArticleSys:articles:list')")
    @GetMapping("/list")
    public TableDataInfo list(Articles articles)
    {
        startPage();
        List<Articles> list = articlesService.selectArticlesList(articles);
        return getDataTable(list);
    }

    /**
     * 导出公告宣传管理列表
     */
    @PreAuthorize("@ss.hasPermi('ArticleSys:articles:export')")
    @Log(title = "公告宣传管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Articles articles)
    {
        List<Articles> list = articlesService.selectArticlesList(articles);
        ExcelUtil<Articles> util = new ExcelUtil<Articles>(Articles.class);
        util.exportExcel(response, list, "公告宣传管理数据");
    }

    /**
     * 获取公告宣传管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ArticleSys:articles:query')")
    @GetMapping(value = "/{articleId}")
    public AjaxResult getInfo(@PathVariable("articleId") Integer articleId)
    {
        return success(articlesService.selectArticlesByArticleId(articleId));
    }

    /**
     * 新增公告宣传管理
     */
    @PreAuthorize("@ss.hasPermi('ArticleSys:articles:add')")
    @Log(title = "公告宣传管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Articles articles)
    {
        return toAjax(articlesService.insertArticles(articles));
    }

    /**
     * 修改公告宣传管理
     */
    @PreAuthorize("@ss.hasPermi('ArticleSys:articles:edit')")
    @Log(title = "公告宣传管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Articles articles)
    {
        return toAjax(articlesService.updateArticles(articles));
    }

    /**
     * 删除公告宣传管理
     */
    @PreAuthorize("@ss.hasPermi('ArticleSys:articles:remove')")
    @Log(title = "公告宣传管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{articleIds}")
    public AjaxResult remove(@PathVariable Integer[] articleIds)
    {
        return toAjax(articlesService.deleteArticlesByArticleIds(articleIds));
    }
}
