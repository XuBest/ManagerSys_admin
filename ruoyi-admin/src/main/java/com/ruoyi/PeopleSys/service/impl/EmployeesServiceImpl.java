package com.ruoyi.PeopleSys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.PeopleSys.mapper.EmployeesMapper;
import com.ruoyi.PeopleSys.domain.Employees;
import com.ruoyi.PeopleSys.service.IEmployeesService;

/**
 * 职工信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class EmployeesServiceImpl implements IEmployeesService 
{
    @Autowired
    private EmployeesMapper employeesMapper;

    /**
     * 查询职工信息管理
     * 
     * @param EmployeeId 职工信息管理主键
     * @return 职工信息管理
     */
    @Override
    public Employees selectEmployeesByEmployeeId(Integer EmployeeId)
    {
        return employeesMapper.selectEmployeesByEmployeeId(EmployeeId);
    }

    /**
     * 查询职工信息管理列表
     * 
     * @param employees 职工信息管理
     * @return 职工信息管理
     */
    @Override
    public List<Employees> selectEmployeesList(Employees employees)
    {
        return employeesMapper.selectEmployeesList(employees);
    }

    /**
     * 新增职工信息管理
     * 
     * @param employees 职工信息管理
     * @return 结果
     */
    @Override
    public int insertEmployees(Employees employees)
    {
        return employeesMapper.insertEmployees(employees);
    }

    /**
     * 修改职工信息管理
     * 
     * @param employees 职工信息管理
     * @return 结果
     */
    @Override
    public int updateEmployees(Employees employees)
    {
        return employeesMapper.updateEmployees(employees);
    }

    /**
     * 批量删除职工信息管理
     * 
     * @param EmployeeIds 需要删除的职工信息管理主键
     * @return 结果
     */
    @Override
    public int deleteEmployeesByEmployeeIds(Integer[] EmployeeIds)
    {
        return employeesMapper.deleteEmployeesByEmployeeIds(EmployeeIds);
    }

    /**
     * 删除职工信息管理信息
     * 
     * @param EmployeeId 职工信息管理主键
     * @return 结果
     */
    @Override
    public int deleteEmployeesByEmployeeId(Integer EmployeeId)
    {
        return employeesMapper.deleteEmployeesByEmployeeId(EmployeeId);
    }
}
