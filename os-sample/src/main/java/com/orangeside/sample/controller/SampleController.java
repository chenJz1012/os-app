package com.orangeside.sample.controller;

import com.orangeside.common.exception.BusinessException;
import com.orangeside.sample.exception.SampleBusinessException;
import com.orangeside.sample.exception.SampleBzConstant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/7 说明：
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("")
    public String page() throws Exception {
        return "modules/os-sample/page";
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
        throw new SampleBusinessException(SampleBzConstant.TEST_ERROR);
    }
}
