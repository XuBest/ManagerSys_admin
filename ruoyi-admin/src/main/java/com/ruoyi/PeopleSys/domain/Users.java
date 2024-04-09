package com.ruoyi.PeopleSys.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息管理对象 users
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public class Users extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Integer uid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String upassword;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String telephone;

    /** 新增时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "新增时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registrationtime;

    public void setUid(Integer uid) 
    {
        this.uid = uid;
    }

    public Integer getUid() 
    {
        return uid;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setUpassword(String upassword) 
    {
        this.upassword = upassword;
    }

    public String getUpassword() 
    {
        return upassword;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setRegistrationtime(Date registrationtime) 
    {
        this.registrationtime = registrationtime;
    }

    public Date getRegistrationtime() 
    {
        return registrationtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uid", getUid())
            .append("username", getUsername())
            .append("upassword", getUpassword())
            .append("telephone", getTelephone())
            .append("registrationtime", getRegistrationtime())
            .toString();
    }
}
