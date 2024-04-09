package com.ruoyi.PeopleSys.service;

import java.util.List;
import com.ruoyi.PeopleSys.domain.Employees;

/**
 * 职工信息管理Service接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface IEmployeesService 
{
    /**
     * 查询职工信息管理
     * 
     * @param EmployeeId 职工信息管理主键
     * @return 职工信息管理
     */
    public Employees selectEmployeesByEmployeeId(Integer EmployeeId);

    /**
     * 查询职工信息管理列表
     * 
     * @param employees 职工信息管理
     * @return 职工信息管理集合
     */
    public List<Employees> selectEmployeesList(Employees employees);

    /**
     * 新增职工信息管理
     * 
     * @param employees 职工信息管理
     * @return 结果
     */
    public int insertEmployees(Employees employees);

    /**
     * 修改职工信息管理
     * 
     * @param employees 职工信息管理
     * @return 结果
     */
    public int updateEmployees(Employees employees);

    /**
     * 批量删除职工信息管理
     * 
     * @param EmployeeIds 需要删除的职工信息管理主键集合
     * @return 结果
     */
    public int deleteEmployeesByEmployeeIds(Integer[] EmployeeIds);

    /**
     * 删除职工信息管理信息
     * 
     * @param EmployeeId 职工信息管理主键
     * @return 结果
     */
    public int deleteEmployeesByEmployeeId(Integer EmployeeId);
}
