package com.orangeside.authorization.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orangeside.authorization.dao.UserMapper;
import com.orangeside.authorization.model.User;
import com.orangeside.authorization.service.UserService;
import com.orangeside.authorization.utils.SecurityUtils;
import com.orangeside.dao.service.impl.BaseService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/2 说明：
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User>
        implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        user.setPassword(SecurityUtils.encodeString(user.getPassword()));
        return getMapper().insert(user);
    }

    @Override
    public int updateUser(User user) {
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(SecurityUtils.encodeString(user.getPassword()));
        }
        return getMapper().updateByPrimaryKey(user);
    }

    @Override
    public User findUserById(int id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public User findUserByLoginName(String loginName) {
        return userMapper.findUserByLoginName(loginName);
    }

    @Override
    public int deleteUser(int id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insertUserRole(int userId, int roleId) {
        return userMapper.insertUserRole(userId, roleId);
    }

    @Override
    public List<Integer> findUserRoleByUserId(int userId) {
        return userMapper.findUserRoleByUserId(userId);
    }

    @Override
    public PageInfo<User> findUserList(Integer pageNum, Integer pageSize, User user) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.findUserList(user);
        PageInfo<User> page = new PageInfo<User>(list);
        return page;
    }

    @Override
    public int findExistUser(User user) {
        return userMapper.findExistUser(user);
    }
}
