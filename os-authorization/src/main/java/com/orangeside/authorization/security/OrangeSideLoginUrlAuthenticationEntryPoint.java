package com.orangeside.authorization.security;

import com.orangeside.common.utils.RequestUtil;
import com.orangeside.common.utils.ResponseUtil;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 工程：os-app 创建人 : ChenGJ 创建时间： 2015/9/10 说明：
 */
public class OrangeSideLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    public OrangeSideLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (RequestUtil.isAjax(request)) {
            ResponseUtil.writeJson(response, false, 304, "请先登录系统！", getLoginFormUrl());
            return;
        }
        super.commence(request, response, authException);
    }
}
