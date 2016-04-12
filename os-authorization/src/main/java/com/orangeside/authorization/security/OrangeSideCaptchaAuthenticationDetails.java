package com.orangeside.authorization.security;

import com.orangeside.patchca.service.Captcha;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class OrangeSideCaptchaAuthenticationDetails implements Serializable {

    private static final long serialVersionUID = 8047091036777813803L;

    private final String answer;
    private final String captcha;

    public OrangeSideCaptchaAuthenticationDetails(HttpServletRequest req) {
        this.answer = req.getParameter(OrangeSideSecurityConstant.CAPTCHA_REQUEST_KEY);
        this.captcha = (String) WebUtils
            .getSessionAttribute(req, OrangeSideSecurityConstant.CAPTCHA_SESSION_KEY);
    }

    public String getAnswer() {
        return answer;
    }

    public String getCaptcha() {
        return captcha;
    }

}
