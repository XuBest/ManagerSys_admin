package com.ruoyi.ActivitySys.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报名信息管理对象 registrations
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Registrations extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报名信息ID */
    @Excel(name = "报名信息ID")
    private Integer RegId;

    /** 报名用户ID */
    @Excel(name = "报名用户ID")
    private Integer UserId;

    /** 活动ID */
    @Excel(name = "活动ID")
    private Integer EventId;

    /** 报名信息状态 */
    @Excel(name = "报名信息状态")
    private String RegStatus;

    /** 报名时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报名时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date RegTime;

    public void setRegId(Integer RegId) 
    {
        this.RegId = RegId;
    }

    public Integer getRegId() 
    {
        return RegId;
    }
    public void setUserId(Integer UserId) 
    {
        this.UserId = UserId;
    }

    public Integer getUserId() 
    {
        return UserId;
    }
    public void setEventId(Integer EventId) 
    {
        this.EventId = EventId;
    }

    public Integer getEventId() 
    {
        return EventId;
    }
    public void setRegStatus(String RegStatus) 
    {
        this.RegStatus = RegStatus;
    }

    public String getRegStatus() 
    {
        return RegStatus;
    }
    public void setRegTime(Date RegTime) 
    {
        this.RegTime = RegTime;
    }

    public Date getRegTime() 
    {
        return RegTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("RegId", getRegId())
            .append("UserId", getUserId())
            .append("EventId", getEventId())
            .append("RegStatus", getRegStatus())
            .append("RegTime", getRegTime())
            .toString();
    }
}
