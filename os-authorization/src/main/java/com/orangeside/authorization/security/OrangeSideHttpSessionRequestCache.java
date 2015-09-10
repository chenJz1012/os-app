package com.orangeside.authorization.security;

import com.orangeside.common.utils.RequestUtil;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/10
 * 说明：
 */
public class OrangeSideHttpSessionRequestCache extends HttpSessionRequestCache {
    /**
     * Stores the current request, provided the configuration properties allow it.
     *
     * @param request
     * @param response
     */
    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if(RequestUtil.isAjax(request)){
            removeRequest(request,response);
            return;
        }
        super.saveRequest(request, response);
    }
}
