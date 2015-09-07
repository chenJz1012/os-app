package com.orangeside.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/7
 * 说明：
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    private final static String ERROR_404 = "error/404";
    private final static String ERROR_500 = "error/500";

    @RequestMapping("/pageNotFound")
    public String pageNotFound() throws Exception {
        return ERROR_404;
    }

    @RequestMapping("/internalServerError")
    public String internalServerError() throws Exception {
        return ERROR_500;
    }
}
