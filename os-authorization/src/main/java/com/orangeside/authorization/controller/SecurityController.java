package com.orangeside.authorization.controller;

import com.orangeside.authorization.security.OrangeSideSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/1
 * 说明：
 */
@Controller
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SessionRegistry sessionRegistry;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/web/onlineUser")
    public
    @ResponseBody
    Object onlineUser() {
        List<SessionInformation> sessions = new ArrayList<SessionInformation>();
        for (Object o : sessionRegistry.getAllPrincipals()) {
            for (SessionInformation sessionInformation : sessionRegistry.getAllSessions(o, false)) {
                sessions.add(sessionInformation);
            }
        }
        return sessions;
    }

    @RequestMapping(value = "/web/loginState", produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String loginState() {
        StringBuffer stringBuffer = new StringBuffer();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof OrangeSideSecurityUser) {
            username = ((OrangeSideSecurityUser) principal).getUsername();
            stringBuffer.append("var siLogin = true;");
        } else {
            username = principal.toString();
            stringBuffer.append("var siLogin = false;");
        }
        stringBuffer.append("var username = " + username + ";");
        return stringBuffer.toString();
    }
}
