package com.ruoyi.AboutSys.mapper;

import java.util.List;
import com.ruoyi.AboutSys.domain.Feedback;

/**
 * 用户反馈管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface FeedbackMapper 
{
    /**
     * 查询用户反馈管理
     * 
     * @param fbId 用户反馈管理主键
     * @return 用户反馈管理
     */
    public Feedback selectFeedbackByFbId(Integer fbId);

    /**
     * 查询用户反馈管理列表
     * 
     * @param feedback 用户反馈管理
     * @return 用户反馈管理集合
     */
    public List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增用户反馈管理
     * 
     * @param feedback 用户反馈管理
     * @return 结果
     */
    public int insertFeedback(Feedback feedback);

    /**
     * 修改用户反馈管理
     * 
     * @param feedback 用户反馈管理
     * @return 结果
     */
    public int updateFeedback(Feedback feedback);

    /**
     * 删除用户反馈管理
     * 
     * @param fbId 用户反馈管理主键
     * @return 结果
     */
    public int deleteFeedbackByFbId(Integer fbId);

    /**
     * 批量删除用户反馈管理
     * 
     * @param fbIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeedbackByFbIds(Integer[] fbIds);
}