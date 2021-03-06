package com.orangeside.authorization.security.http;

import com.orangeside.common.utils.HttpResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/10 说明：
 */
public class OrangeSideHttpAccessDeniedHandler implements AccessDeniedHandler {

    protected static final Logger logger = LoggerFactory.getLogger(OrangeSideHttpAccessDeniedHandler.class);


    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        HttpResponseUtil.error(response, HttpServletResponse.SC_FORBIDDEN, "没有权限访问!");
    }

}
