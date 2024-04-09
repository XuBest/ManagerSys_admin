package com.ruoyi.ArticleSys.mapper;

import java.util.List;
import com.ruoyi.ArticleSys.domain.Articles;

/**
 * 公告宣传管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface ArticlesMapper 
{
    /**
     * 查询公告宣传管理
     * 
     * @param articleId 公告宣传管理主键
     * @return 公告宣传管理
     */
    public Articles selectArticlesByArticleId(Integer articleId);

    /**
     * 查询公告宣传管理列表
     * 
     * @param articles 公告宣传管理
     * @return 公告宣传管理集合
     */
    public List<Articles> selectArticlesList(Articles articles);

    /**
     * 新增公告宣传管理
     * 
     * @param articles 公告宣传管理
     * @return 结果
     */
    public int insertArticles(Articles articles);

    /**
     * 修改公告宣传管理
     * 
     * @param articles 公告宣传管理
     * @return 结果
     */
    public int updateArticles(Articles articles);

    /**
     * 删除公告宣传管理
     * 
     * @param articleId 公告宣传管理主键
     * @return 结果
     */
    public int deleteArticlesByArticleId(Integer articleId);

    /**
     * 批量删除公告宣传管理
     * 
     * @param articleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticlesByArticleIds(Integer[] articleIds);
}
