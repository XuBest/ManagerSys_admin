package com.ruoyi.ActivitySys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ActivitySys.mapper.EventsMapper;
import com.ruoyi.ActivitySys.domain.Events;
import com.ruoyi.ActivitySys.service.IEventsService;

/**
 * 活动发布管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class EventsServiceImpl implements IEventsService 
{
    @Autowired
    private EventsMapper eventsMapper;

    /**
     * 查询活动发布管理
     * 
     * @param EventId 活动发布管理主键
     * @return 活动发布管理
     */
    @Override
    public Events selectEventsByEventId(Integer EventId)
    {
        return eventsMapper.selectEventsByEventId(EventId);
    }

    /**
     * 查询活动发布管理列表
     * 
     * @param events 活动发布管理
     * @return 活动发布管理
     */
    @Override
    public List<Events> selectEventsList(Events events)
    {
        return eventsMapper.selectEventsList(events);
    }

    /**
     * 新增活动发布管理
     * 
     * @param events 活动发布管理
     * @return 结果
     */
    @Override
    public int insertEvents(Events events)
    {
        return eventsMapper.insertEvents(events);
    }

    /**
     * 修改活动发布管理
     * 
     * @param events 活动发布管理
     * @return 结果
     */
    @Override
    public int updateEvents(Events events)
    {
        return eventsMapper.updateEvents(events);
    }

    /**
     * 批量删除活动发布管理
     * 
     * @param EventIds 需要删除的活动发布管理主键
     * @return 结果
     */
    @Override
    public int deleteEventsByEventIds(Integer[] EventIds)
    {
        return eventsMapper.deleteEventsByEventIds(EventIds);
    }

    /**
     * 删除活动发布管理信息
     * 
     * @param EventId 活动发布管理主键
     * @return 结果
     */
    @Override
    public int deleteEventsByEventId(Integer EventId)
    {
        return eventsMapper.deleteEventsByEventId(EventId);
    }
}
