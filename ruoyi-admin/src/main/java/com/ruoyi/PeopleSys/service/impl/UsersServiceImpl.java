package com.ruoyi.PeopleSys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.PeopleSys.mapper.UsersMapper;
import com.ruoyi.PeopleSys.domain.Users;
import com.ruoyi.PeopleSys.service.IUsersService;

/**
 * 用户信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-10
 */
@Service
public class UsersServiceImpl implements IUsersService 
{
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询用户信息管理
     * 
     * @param uid 用户信息管理主键
     * @return 用户信息管理
     */
    @Override
    public Users selectUsersByUid(Integer uid)
    {
        return usersMapper.selectUsersByUid(uid);
    }

    /**
     * 查询用户信息管理列表
     * 
     * @param users 用户信息管理
     * @return 用户信息管理
     */
    @Override
    public List<Users> selectUsersList(Users users)
    {
        return usersMapper.selectUsersList(users);
    }

    /**
     * 新增用户信息管理
     * 
     * @param users 用户信息管理
     * @return 结果
     */
    @Override
    public int insertUsers(Users users)
    {
        return usersMapper.insertUsers(users);
    }

    /**
     * 修改用户信息管理
     * 
     * @param users 用户信息管理
     * @return 结果
     */
    @Override
    public int updateUsers(Users users)
    {
        return usersMapper.updateUsers(users);
    }

    /**
     * 批量删除用户信息管理
     * 
     * @param uids 需要删除的用户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUids(Integer[] uids)
    {
        return usersMapper.deleteUsersByUids(uids);
    }

    /**
     * 删除用户信息管理信息
     * 
     * @param uid 用户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUid(Integer uid)
    {
        return usersMapper.deleteUsersByUid(uid);
    }
}
