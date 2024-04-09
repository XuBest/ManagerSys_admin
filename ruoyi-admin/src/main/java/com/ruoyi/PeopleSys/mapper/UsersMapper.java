package com.ruoyi.PeopleSys.mapper;

import java.util.List;
import com.ruoyi.PeopleSys.domain.Users;

/**
 * 用户信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
public interface UsersMapper 
{
    /**
     * 查询用户信息管理
     * 
     * @param uid 用户信息管理主键
     * @return 用户信息管理
     */
    public Users selectUsersByUid(Integer uid);

    /**
     * 查询用户信息管理列表
     * 
     * @param users 用户信息管理
     * @return 用户信息管理集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增用户信息管理
     * 
     * @param users 用户信息管理
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改用户信息管理
     * 
     * @param users 用户信息管理
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 删除用户信息管理
     * 
     * @param uid 用户信息管理主键
     * @return 结果
     */
    public int deleteUsersByUid(Integer uid);

    /**
     * 批量删除用户信息管理
     * 
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUsersByUids(Integer[] uids);
}
