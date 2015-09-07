package com.orangeside.web.controller;

import com.orangeside.common.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/7
 * 说明：
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("")
    public String test() throws Exception {
        return "test/test";
    }

    @RequestMapping("/normalError")
    public String normalError() throws Exception {
        throw new Exception("normalError");
    }

    @RequestMapping("/ajaxError")
    public
    @ResponseBody
    Object ajaxError() throws Exception {
        throw new Exception("ajaxError");
    }

    @RequestMapping("/normalBusinessError")
    public String normalBusinessError() throws Exception {
        throw new BusinessException(1001);
    }
}