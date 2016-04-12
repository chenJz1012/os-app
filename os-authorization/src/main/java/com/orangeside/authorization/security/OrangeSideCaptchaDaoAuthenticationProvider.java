package com.orangeside.authorization.security;

import com.orangeside.authorization.utils.SecurityUtils;
import com.orangeside.patchca.service.Captcha;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class OrangeSideCaptchaDaoAuthenticationProvider extends DaoAuthenticationProvider {

    @Override protected void additionalAuthenticationChecks(UserDetails userDetails,
        UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        super.additionalAuthenticationChecks(userDetails, token);

        Object obj = token.getDetails();
        if (!(obj instanceof OrangeSideCaptchaAuthenticationDetails)) {
            throw new InsufficientAuthenticationException("未找到验证码");
        }

        OrangeSideCaptchaAuthenticationDetails captchaDetails =
            (OrangeSideCaptchaAuthenticationDetails) obj;
        String captcha = captchaDetails.getCaptcha();
        if (captcha != null) {
            String expected = captcha;
            String actual = captchaDetails.getAnswer();
            if (!SecurityUtils.matchString(actual, expected)) {
                throw new BadCredentialsException("验证码不正确");
            }
        }
    }

}
