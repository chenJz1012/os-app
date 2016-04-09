package com.orangeside.authorization.dao;

import com.orangeside.authorization.model.User;
import com.orangeside.authorization.vo.UserVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    User findUserByLoginName(String loginName);

    int insertUserRole(int userId, int roleId);

    List<Integer> findUserRoleByUserId(int userId);

    List<UserVO> findUserList(User user);
}
