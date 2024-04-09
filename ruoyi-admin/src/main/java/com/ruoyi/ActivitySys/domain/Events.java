package com.ruoyi.ActivitySys.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动发布管理对象 events
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Events extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 活动id */
    @Excel(name = "活动id")
    private Integer EventId;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String EventName;

    /** 活动内容 */
    @Excel(name = "活动内容")
    private String EventContent;

    /** 活动容量 */
    @Excel(name = "活动容量")
    private Long MaxJoin;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date PublishTime;

    /** 报名截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报名截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date EndTime;

    /** 活动状态 */
    @Excel(name = "活动状态")
    private String EventStatus;

    public void setEventId(Integer EventId) 
    {
        this.EventId = EventId;
    }

    public Integer getEventId() 
    {
        return EventId;
    }
    public void setEventName(String EventName) 
    {
        this.EventName = EventName;
    }

    public String getEventName() 
    {
        return EventName;
    }
    public void setEventContent(String EventContent) 
    {
        this.EventContent = EventContent;
    }

    public String getEventContent() 
    {
        return EventContent;
    }
    public void setMaxJoin(Long MaxJoin) 
    {
        this.MaxJoin = MaxJoin;
    }

    public Long getMaxJoin() 
    {
        return MaxJoin;
    }
    public void setPublishTime(Date PublishTime) 
    {
        this.PublishTime = PublishTime;
    }

    public Date getPublishTime() 
    {
        return PublishTime;
    }
    public void setEndTime(Date EndTime) 
    {
        this.EndTime = EndTime;
    }

    public Date getEndTime() 
    {
        return EndTime;
    }
    public void setEventStatus(String EventStatus) 
    {
        this.EventStatus = EventStatus;
    }

    public String getEventStatus() 
    {
        return EventStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("EventId", getEventId())
            .append("EventName", getEventName())
            .append("EventContent", getEventContent())
            .append("MaxJoin", getMaxJoin())
            .append("PublishTime", getPublishTime())
            .append("EndTime", getEndTime())
            .append("EventStatus", getEventStatus())
            .toString();
    }
}
