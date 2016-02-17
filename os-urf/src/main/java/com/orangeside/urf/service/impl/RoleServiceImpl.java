package com.orangeside.urf.service.impl;

import com.orangeside.urf.dao.RoleMapper;
import com.orangeside.urf.model.Role;
import com.orangeside.urf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/3
 * 说明：
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleMapper roleMapper;

    @Override
    public int insertRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public Role findRoleById(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteRole(int id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertRoleFunction(int roleId, int functionId) {
        return roleMapper.insertRoleFunction(roleId, functionId);
    }

    @Override
    public List<Map> findRoleMatchUpFunctions() {
        return roleMapper.findRoleMatchUpFunctions();
    }
}
