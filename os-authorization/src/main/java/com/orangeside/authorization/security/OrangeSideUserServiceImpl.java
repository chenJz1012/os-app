package com.orangeside.authorization.security;

import com.orangeside.authorization.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/4 说明：
 */
public class OrangeSideUserServiceImpl implements UserDetailsService {
    @Autowired
    SecurityService securityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OrangeSideSecurityUser orangeSideSecurityUser = securityService.loadSecurityUserByLoginName(username);
        if (orangeSideSecurityUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return orangeSideSecurityUser;
    }
}
