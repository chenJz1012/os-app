package com.orangeside.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/1
 * 说明：
 */
@Controller
public class SecurityController {
    @Autowired
    SessionRegistry sessionRegistry;
    @RequestMapping("/security/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/security/onlineUser")
    public
    @ResponseBody
    Object onlineUser(){
        List<SessionInformation> sessions = new ArrayList<SessionInformation>();
        for (Object o : sessionRegistry.getAllPrincipals()) {
            for (SessionInformation sessionInformation : sessionRegistry.getAllSessions(o, false)) {
                sessions.add(sessionInformation);
            }
        }
        return sessions;
    }
}
