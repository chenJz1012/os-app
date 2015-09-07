package com.orangeside.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/1
 * 说明：
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String root() {
        return "redirect:index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
