package com.orangeside.authorization.utils;

import com.orangeside.authorization.security.OrangeSideSecurityUser;
import com.orangeside.urf.model.User;
import com.orangeside.urf.service.UserService;
import com.orangeside.urf.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Created by cgj on 2015/10/26.
 */
public class SecurityUtils {
    public static String getCurrentUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = null;
        if (principal instanceof OrangeSideSecurityUser)
            userName = ((OrangeSideSecurityUser) principal).getUsername();
        return userName;
    }

    public static OrangeSideSecurityUser getCurrentSecurityUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = null;
        if (principal instanceof OrangeSideSecurityUser)
            return (OrangeSideSecurityUser) principal;
        return null;
    }
}
