package com.ruoyi.ActivitySys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ActivitySys.mapper.RegistrationsMapper;
import com.ruoyi.ActivitySys.domain.Registrations;
import com.ruoyi.ActivitySys.service.IRegistrationsService;

/**
 * 报名信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class RegistrationsServiceImpl implements IRegistrationsService 
{
    @Autowired
    private RegistrationsMapper registrationsMapper;

    /**
     * 查询报名信息管理
     * 
     * @param RegId 报名信息管理主键
     * @return 报名信息管理
     */
    @Override
    public Registrations selectRegistrationsByRegId(Integer RegId)
    {
        return registrationsMapper.selectRegistrationsByRegId(RegId);
    }

    /**
     * 查询报名信息管理列表
     * 
     * @param registrations 报名信息管理
     * @return 报名信息管理
     */
    @Override
    public List<Registrations> selectRegistrationsList(Registrations registrations)
    {
        return registrationsMapper.selectRegistrationsList(registrations);
    }

    /**
     * 新增报名信息管理
     * 
     * @param registrations 报名信息管理
     * @return 结果
     */
    @Override
    public int insertRegistrations(Registrations registrations)
    {
        return registrationsMapper.insertRegistrations(registrations);
    }

    /**
     * 修改报名信息管理
     * 
     * @param registrations 报名信息管理
     * @return 结果
     */
    @Override
    public int updateRegistrations(Registrations registrations)
    {
        return registrationsMapper.updateRegistrations(registrations);
    }

    /**
     * 批量删除报名信息管理
     * 
     * @param RegIds 需要删除的报名信息管理主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationsByRegIds(Integer[] RegIds)
    {
        return registrationsMapper.deleteRegistrationsByRegIds(RegIds);
    }

    /**
     * 删除报名信息管理信息
     * 
     * @param RegId 报名信息管理主键
     * @return 结果
     */
    @Override
    public int deleteRegistrationsByRegId(Integer RegId)
    {
        return registrationsMapper.deleteRegistrationsByRegId(RegId);
    }
}
