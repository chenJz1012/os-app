package com.orangeside.urf.service;

import com.github.pagehelper.PageInfo;
import com.orangeside.urf.model.User;
import com.orangeside.urf.vo.UserVO;

import java.util.List;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/2
 * 说明：
 */
public interface UserService {
    int insertUser(User user);

    int updateUser(User user);

    User findUserById(int id);

    User findUserByLoginName(String loginName);

    int deleteUser(int id);

    int insertUserRole(int userId, int roleId);

    List<Integer> findUserRoleByUserId(int userId);

    PageInfo<UserVO> findUserList(Integer pageNum, Integer pageSize, User user);
}
