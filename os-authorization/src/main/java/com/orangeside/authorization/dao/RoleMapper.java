package com.orangeside.authorization.dao;

import com.orangeside.authorization.model.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {

    int insertRoleFunction(int roleId, int functionId);

    List<Map> findRoleMatchUpFunctions();
}
