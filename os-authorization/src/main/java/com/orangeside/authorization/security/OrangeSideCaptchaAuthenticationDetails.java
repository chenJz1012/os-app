package com.orangeside.authorization.security;

import com.orangeside.common.utils.RequestUtil;

import org.springframework.web.util.WebUtils;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class OrangeSideCaptchaAuthenticationDetails implements Serializable {

    private static final long serialVersionUID = 8047091036777813803L;

    private final String answer;
    private final String captcha;

    public OrangeSideCaptchaAuthenticationDetails(HttpServletRequest req) {
        if (!RequestUtil.isAjax(req)) {
            this.answer = req.getParameter(OrangeSideSecurityConstant.CAPTCHA_REQUEST_KEY);
            this.captcha = (String) WebUtils
                    .getSessionAttribute(req, OrangeSideSecurityConstant.CAPTCHA_SESSION_KEY);
        } else {
            this.answer = null;
            this.captcha = null;
        }

    }

    public String getAnswer() {
        return answer;
    }

    public String getCaptcha() {
        return captcha;
    }

}
