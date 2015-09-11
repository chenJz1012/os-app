package com.orangeside.authorization.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/4
 * 说明：
 */
public class OrangeSideSecurityUser extends User{
    public OrangeSideSecurityUser(com.orangeside.urf.model.User user, Collection<GrantedAuthority> userGrantedAuthorities){
        super(user.getLoginName(),user.getPassword(),user.getEnabled(),user.getAccountNonExpired(),user.getCredentialsNonExpired(),user.getAccountNonLocked(), userGrantedAuthorities);
    }
}
