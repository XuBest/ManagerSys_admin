package com.ruoyi.ActivitySys.mapper;

import java.util.List;
import com.ruoyi.ActivitySys.domain.Events;

/**
 * 活动发布管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface EventsMapper 
{
    /**
     * 查询活动发布管理
     * 
     * @param EventId 活动发布管理主键
     * @return 活动发布管理
     */
    public Events selectEventsByEventId(Integer EventId);

    /**
     * 查询活动发布管理列表
     * 
     * @param events 活动发布管理
     * @return 活动发布管理集合
     */
    public List<Events> selectEventsList(Events events);

    /**
     * 新增活动发布管理
     * 
     * @param events 活动发布管理
     * @return 结果
     */
    public int insertEvents(Events events);

    /**
     * 修改活动发布管理
     * 
     * @param events 活动发布管理
     * @return 结果
     */
    public int updateEvents(Events events);

    /**
     * 删除活动发布管理
     * 
     * @param EventId 活动发布管理主键
     * @return 结果
     */
    public int deleteEventsByEventId(Integer EventId);

    /**
     * 批量删除活动发布管理
     * 
     * @param EventIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEventsByEventIds(Integer[] EventIds);
}