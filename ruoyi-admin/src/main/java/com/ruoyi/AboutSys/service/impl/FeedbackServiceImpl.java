package com.ruoyi.AboutSys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.AboutSys.mapper.FeedbackMapper;
import com.ruoyi.AboutSys.domain.Feedback;
import com.ruoyi.AboutSys.service.IFeedbackService;

/**
 * 用户反馈管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService 
{
    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 查询用户反馈管理
     * 
     * @param fbId 用户反馈管理主键
     * @return 用户反馈管理
     */
    @Override
    public Feedback selectFeedbackByFbId(Integer fbId)
    {
        return feedbackMapper.selectFeedbackByFbId(fbId);
    }

    /**
     * 查询用户反馈管理列表
     * 
     * @param feedback 用户反馈管理
     * @return 用户反馈管理
     */
    @Override
    public List<Feedback> selectFeedbackList(Feedback feedback)
    {
        return feedbackMapper.selectFeedbackList(feedback);
    }

    /**
     * 新增用户反馈管理
     * 
     * @param feedback 用户反馈管理
     * @return 结果
     */
    @Override
    public int insertFeedback(Feedback feedback)
    {
        feedback.setCreateTime(DateUtils.getNowDate());
        return feedbackMapper.insertFeedback(feedback);
    }

    /**
     * 修改用户反馈管理
     * 
     * @param feedback 用户反馈管理
     * @return 结果
     */
    @Override
    public int updateFeedback(Feedback feedback)
    {
        return feedbackMapper.updateFeedback(feedback);
    }

    /**
     * 批量删除用户反馈管理
     * 
     * @param fbIds 需要删除的用户反馈管理主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByFbIds(Integer[] fbIds)
    {
        return feedbackMapper.deleteFeedbackByFbIds(fbIds);
    }

    /**
     * 删除用户反馈管理信息
     * 
     * @param fbId 用户反馈管理主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByFbId(Integer fbId)
    {
        return feedbackMapper.deleteFeedbackByFbId(fbId);
    }
}
