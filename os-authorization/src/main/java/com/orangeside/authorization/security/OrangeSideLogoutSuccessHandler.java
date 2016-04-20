package com.orangeside.authorization.security;

import com.orangeside.common.utils.RequestUtil;
import com.orangeside.common.utils.ResponseUtil;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WL on 2015/9/9.
 */
public class OrangeSideLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
        implements LogoutSuccessHandler {
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        if (RequestUtil.isAjax(request)) {
            ResponseUtil.writeJson(response, true, null, "登出成功！", targetUrl);
        } else {
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        }
    }

}
