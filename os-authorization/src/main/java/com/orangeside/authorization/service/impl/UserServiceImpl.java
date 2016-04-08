package com.orangeside.authorization.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orangeside.authorization.dao.UserMapper;
import com.orangeside.authorization.model.User;
import com.orangeside.authorization.service.UserService;
import com.orangeside.authorization.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/2
 * 说明：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findUserByLoginName(String loginName) {
        return userMapper.findUserByLoginName(loginName);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertUserRole(int userId, int roleId) {
        return userMapper.insertUserRole(userId, roleId);
    }

    @Override
    public List<Integer> findUserRoleByUserId(int userId) {
        return userMapper.findUserRoleByUserId(userId);
    }

    @Override public PageInfo<UserVO> findUserList(Integer pageNum, Integer pageSize, User user) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserVO> list = userMapper.findUserList(user);
        PageInfo<UserVO> page = new PageInfo<UserVO>(list);
        return page;
    }
}
