package com.ruoyi.PeopleSys.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职工信息管理对象 employees
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Employees extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工id */
    @Excel(name = "员工id")
    private Integer EmployeeId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String EmployeeName;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phonenumber;

    /** 岗位 */
    @Excel(name = "岗位")
    private String position;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String department;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enterDate;

    /** 就职状态 */
    @Excel(name = "就职状态")
    private String status;

    public void setEmployeeId(Integer EmployeeId) 
    {
        this.EmployeeId = EmployeeId;
    }

    public Integer getEmployeeId() 
    {
        return EmployeeId;
    }
    public void setEmployeeName(String EmployeeName) 
    {
        this.EmployeeName = EmployeeName;
    }

    public String getEmployeeName() 
    {
        return EmployeeName;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setEnterDate(Date enterDate) 
    {
        this.enterDate = enterDate;
    }

    public Date getEnterDate() 
    {
        return enterDate;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("EmployeeId", getEmployeeId())
            .append("EmployeeName", getEmployeeName())
            .append("gender", getGender())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("position", getPosition())
            .append("department", getDepartment())
            .append("enterDate", getEnterDate())
            .append("status", getStatus())
            .toString();
    }
}
