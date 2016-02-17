package com.orangeside.urf.service;

import com.orangeside.urf.model.Role;

import java.util.List;
import java.util.Map;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/3
 * 说明：
 */
public interface RoleService {
    int insertRole(Role role);

    int updateRole(Role role);

    Role findRoleById(int id);

    int deleteRole(int id);

    int insertRoleFunction(int roleId, int functionId);

    List<Map> findRoleMatchUpFunctions();
}
