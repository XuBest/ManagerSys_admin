package com.ruoyi.ArticleSys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ArticleSys.mapper.ArticlesMapper;
import com.ruoyi.ArticleSys.domain.Articles;
import com.ruoyi.ArticleSys.service.IArticlesService;

/**
 * 公告宣传管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class ArticlesServiceImpl implements IArticlesService 
{
    @Autowired
    private ArticlesMapper articlesMapper;

    /**
     * 查询公告宣传管理
     * 
     * @param articleId 公告宣传管理主键
     * @return 公告宣传管理
     */
    @Override
    public Articles selectArticlesByArticleId(Integer articleId)
    {
        return articlesMapper.selectArticlesByArticleId(articleId);
    }

    /**
     * 查询公告宣传管理列表
     * 
     * @param articles 公告宣传管理
     * @return 公告宣传管理
     */
    @Override
    public List<Articles> selectArticlesList(Articles articles)
    {
        return articlesMapper.selectArticlesList(articles);
    }

    /**
     * 新增公告宣传管理
     * 
     * @param articles 公告宣传管理
     * @return 结果
     */
    @Override
    public int insertArticles(Articles articles)
    {
        return articlesMapper.insertArticles(articles);
    }

    /**
     * 修改公告宣传管理
     * 
     * @param articles 公告宣传管理
     * @return 结果
     */
    @Override
    public int updateArticles(Articles articles)
    {
        return articlesMapper.updateArticles(articles);
    }

    /**
     * 批量删除公告宣传管理
     * 
     * @param articleIds 需要删除的公告宣传管理主键
     * @return 结果
     */
    @Override
    public int deleteArticlesByArticleIds(Integer[] articleIds)
    {
        return articlesMapper.deleteArticlesByArticleIds(articleIds);
    }

    /**
     * 删除公告宣传管理信息
     * 
     * @param articleId 公告宣传管理主键
     * @return 结果
     */
    @Override
    public int deleteArticlesByArticleId(Integer articleId)
    {
        return articlesMapper.deleteArticlesByArticleId(articleId);
    }
}
