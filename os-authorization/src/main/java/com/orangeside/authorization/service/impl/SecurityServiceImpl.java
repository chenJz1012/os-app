package com.orangeside.authorization.service.impl;

import com.orangeside.authorization.security.SecurityUser;
import com.orangeside.authorization.service.SecurityService;
import com.orangeside.urf.model.User;
import com.orangeside.urf.service.RoleService;
import com.orangeside.urf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/4
 * 说明：
 */
@Service("securityService")
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    public SecurityUser loadSecurityUserByLoginName(String loginName) {
        User user = userService.findUserByLoginName(loginName);
        if (user == null) {
            return null;
        }
        Collection<GrantedAuthority> userGrantedAuthorities = new ArrayList<GrantedAuthority>();
        List<Integer> grantedAuthorities = userService.findUserRoleByUserId(user.getId());
        if (grantedAuthorities != null && grantedAuthorities.size() > 0) {
            for (Integer grantedAuthority : grantedAuthorities) {
                GrantedAuthority ga = new SimpleGrantedAuthority(String.valueOf(grantedAuthority));
                userGrantedAuthorities.add(ga);
            }
        }
        SecurityUser securityUser = new SecurityUser(user, userGrantedAuthorities);
        return securityUser;
    }

    @Override
    public Map<String, Collection<ConfigAttribute>> getResourceMap() {
        Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<>();
        List<Map> roleFunctions = roleService.findRoleMatchupFunctions();
        if (roleFunctions != null && roleFunctions.size() > 0) {
            for (Map roleFunction : roleFunctions) {
                String url = (String) roleFunction.get("function");
                Integer role = (Integer)roleFunction.get("role");
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                if(!resourceMap.containsKey(url)){
                    configAttributes.add(new SecurityConfig(String.valueOf(role)));
                    resourceMap.put(url,configAttributes);
                }else{
                    ConfigAttribute configAttribute =  new SecurityConfig(String.valueOf(role));
                    configAttributes = resourceMap.get(url);
                    configAttributes.add(configAttribute);
                    resourceMap.put(url, configAttributes);
                }
            }
        }
        return resourceMap;
    }
}
