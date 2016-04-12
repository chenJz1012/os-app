package com.orangeside.patchca.utils;

import com.orangeside.patchca.background.SingleColorBackgroundFactory;
import com.orangeside.patchca.color.SingleColorFactory;
import com.orangeside.patchca.encoder.EncoderHelper;
import com.orangeside.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.orangeside.patchca.service.Captcha;
import com.orangeside.patchca.service.ConfigurableCaptchaService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * Created by cgj on 2016/4/11.
 */
public class ImageUtils {
    public static String getPatchcaString(HttpServletResponse response) throws IOException {
        return getCaptcha(response).getChallenge();
    }

    public static Captcha getCaptcha(HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        cs.setBackgroundFactory(new SingleColorBackgroundFactory(new Color(221,227,236)));
        Captcha captcha = cs.getCaptcha();
        ImageIO.write(captcha.getImage(), "png", response.getOutputStream());
        return captcha;
    }
}
