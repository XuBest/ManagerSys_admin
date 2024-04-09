package com.ruoyi.AboutSys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户反馈管理对象 feedback
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Feedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 反馈唯一标识符 */
    @Excel(name = "反馈唯一标识符")
    private Integer fbId;

    /** 提供反馈的用户ID */
    @Excel(name = "提供反馈的用户ID")
    private Integer uid;

    /** 反馈标题 */
    @Excel(name = "反馈标题")
    private String fbTitle;

    /** 反馈内容 */
    @Excel(name = "反馈内容")
    private String fbContent;

    /** 反馈状态 */
    @Excel(name = "反馈状态")
    private String fbStatus;

    public void setFbId(Integer fbId) 
    {
        this.fbId = fbId;
    }

    public Integer getFbId() 
    {
        return fbId;
    }
    public void setUid(Integer uid) 
    {
        this.uid = uid;
    }

    public Integer getUid() 
    {
        return uid;
    }
    public void setFbTitle(String fbTitle) 
    {
        this.fbTitle = fbTitle;
    }

    public String getFbTitle() 
    {
        return fbTitle;
    }
    public void setFbContent(String fbContent) 
    {
        this.fbContent = fbContent;
    }

    public String getFbContent() 
    {
        return fbContent;
    }
    public void setFbStatus(String fbStatus) 
    {
        this.fbStatus = fbStatus;
    }

    public String getFbStatus() 
    {
        return fbStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fbId", getFbId())
            .append("uid", getUid())
            .append("fbTitle", getFbTitle())
            .append("fbContent", getFbContent())
            .append("fbStatus", getFbStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
