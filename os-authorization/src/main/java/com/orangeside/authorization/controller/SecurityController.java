package com.orangeside.authorization.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/1
 * 说明：
 */
@Controller
public class SecurityController {

    @RequestMapping("/security/login")
    public String login() {
        return "login";
    }
}
