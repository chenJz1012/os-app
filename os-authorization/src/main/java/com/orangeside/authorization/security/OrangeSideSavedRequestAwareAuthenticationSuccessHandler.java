package com.orangeside.authorization.security;

import com.orangeside.authorization.service.SecurityService;
import com.orangeside.common.utils.RequestUtil;
import com.orangeside.common.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/8
 * 说明：
 */
public class OrangeSideSavedRequestAwareAuthenticationSuccessHandler
    extends SimpleUrlAuthenticationSuccessHandler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    private boolean useReferer = false;

    private SecurityService securityService;

    private static final String LOGIN = "登录";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws ServletException, IOException {
        try {
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest == null) {
                handle(request, response, authentication);
                return;
            }
            String targetUrlParameter = getTargetUrlParameter();
            if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils
                .hasText(request.getParameter(targetUrlParameter)))) {
                requestCache.removeRequest(request, response);
                handle(request, response, authentication);
                return;
            }
            clearAuthenticationAttributes(request);
            // Use the DefaultSavedRequest URL
            String targetUrl = savedRequest.getRedirectUrl();
            logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
            decideRedirect(request, response, targetUrl);
        } finally {
            logLoginSuccess(authentication, request);
        }
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

    /**
     * Invokes the configured {@code RedirectStrategy} with the URL returned by the {@code determineTargetUrl} method.
     * <p>
     * The redirect will not be performed if the response has already been committed.
     *
     * @param request
     * @param response
     * @param authentication
     */
    @Override protected void handle(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response, authentication);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        decideRedirect(request, response, targetUrl);
        clearAuthenticationAttributes(request);
    }

    private void logLoginSuccess(Authentication authentication, HttpServletRequest request) {
        String username = "";
        if (authentication.getPrincipal() instanceof OrangeSideSecurityUser) {
            username = ((OrangeSideSecurityUser) authentication.getPrincipal()).getUsername();
        } else {
            username = authentication.getPrincipal().toString();
        }
        logger.info("登录系统成功;日志类型:{};用户:{};登录IP:{};", LOGIN, username,
            RequestUtil.getIpAddress(request));
    }

    private void decideRedirect(HttpServletRequest request, HttpServletResponse response,
        String targetUrl) throws IOException {
        if (RequestUtil.isAjax(request)) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", true);
            map.put("message", "login success!");
            map.put("targetUrl", targetUrl);
            ResponseUtil.writeJson(response, map);
        } else {
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        }
    }

    /**
     * Builds the target URL according to the logic defined in the main class Javadoc.
     *
     * @param request
     * @param response
     */
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) {
        if (isAlwaysUseDefaultTargetUrl()) {
            return getDefaultTargetUrl();
        }
        // Check for the parameter and use that if available
        String targetUrl = null;
        if (getTargetUrlParameter() != null) {
            targetUrl = request.getParameter(getTargetUrlParameter());

            if (StringUtils.hasText(targetUrl)) {
                logger.debug("Found targetUrlParameter in request: " + targetUrl);

                return targetUrl;
            }
        }
        if (useReferer && !StringUtils.hasLength(targetUrl)) {
            targetUrl = request.getHeader("Referer");
            logger.debug("Using Referer header: " + targetUrl);
        }
        String defaultAction = "";
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            defaultAction =
                securityService.getDefaultAction(Integer.valueOf(grantedAuthority.getAuthority()));
            if (StringUtils.hasText(defaultAction)) {
                targetUrl = defaultAction;
                logger.debug("Using role defaultAction: " + targetUrl);
                break;
            }
        }
        if (!StringUtils.hasText(targetUrl)) {
            targetUrl = getDefaultTargetUrl();
            logger.debug("Using default Url: " + targetUrl);
        }
        return targetUrl;
    }

    @Override public void setUseReferer(boolean useReferer) {
        this.useReferer = useReferer;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    /**
     * Invokes the configured {@code RedirectStrategy} with the URL returned by the {@code determineTargetUrl} method.
     * <p/>
     * The redirect will not be performed if the response has already been committed.
     *
     * @param request
     * @param response
     * @param authentication
     */
}
