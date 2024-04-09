package com.ruoyi.ActivitySys.service;

import java.util.List;
import com.ruoyi.ActivitySys.domain.Registrations;

/**
 * 报名信息管理Service接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface IRegistrationsService 
{
    /**
     * 查询报名信息管理
     * 
     * @param RegId 报名信息管理主键
     * @return 报名信息管理
     */
    public Registrations selectRegistrationsByRegId(Integer RegId);

    /**
     * 查询报名信息管理列表
     * 
     * @param registrations 报名信息管理
     * @return 报名信息管理集合
     */
    public List<Registrations> selectRegistrationsList(Registrations registrations);

    /**
     * 新增报名信息管理
     * 
     * @param registrations 报名信息管理
     * @return 结果
     */
    public int insertRegistrations(Registrations registrations);

    /**
     * 修改报名信息管理
     * 
     * @param registrations 报名信息管理
     * @return 结果
     */
    public int updateRegistrations(Registrations registrations);

    /**
     * 批量删除报名信息管理
     * 
     * @param RegIds 需要删除的报名信息管理主键集合
     * @return 结果
     */
    public int deleteRegistrationsByRegIds(Integer[] RegIds);

    /**
     * 删除报名信息管理信息
     * 
     * @param RegId 报名信息管理主键
     * @return 结果
     */
    public int deleteRegistrationsByRegId(Integer RegId);
}
