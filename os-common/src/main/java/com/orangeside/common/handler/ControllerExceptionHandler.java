package com.orangeside.common.handler;

import com.orangeside.common.utils.RequestUtil;
import com.orangeside.common.utils.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/6
 * 说明：
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    private final static String ERROR_500 = "error/500";

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletResponse response, HttpServletRequest request, Exception e) {
        logger.debug("捕获到异常");
        if (RequestUtil.isAjax(request)) {
            logger.debug("异常来源请求为：{}", "ajax请求");
            ResponseUtil.fail(response, e.getMessage());
        } else {
            logger.debug("异常来源请求为：{}", "传统页面请求");
            ModelAndView modelAndView = new ModelAndView(ERROR_500);
            modelAndView.addObject("msg", e.getMessage());
            return modelAndView;
        }
        return null;
    }

}
