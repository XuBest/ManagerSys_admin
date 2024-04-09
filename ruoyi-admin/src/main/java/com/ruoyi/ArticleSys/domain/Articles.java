package com.ruoyi.ArticleSys.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公告宣传管理对象 articles
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Articles extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    @Excel(name = "文章id")
    private Integer articleId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 生成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishtime;

    /** 文章类型 */
    @Excel(name = "文章类型")
    private String category;

    /** 文章发布人 */
    @Excel(name = "文章发布人")
    private String author;

    public void setArticleId(Integer articleId) 
    {
        this.articleId = articleId;
    }

    public Integer getArticleId() 
    {
        return articleId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPublishtime(Date publishtime) 
    {
        this.publishtime = publishtime;
    }

    public Date getPublishtime() 
    {
        return publishtime;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("publishtime", getPublishtime())
            .append("category", getCategory())
            .append("author", getAuthor())
            .toString();
    }
}
