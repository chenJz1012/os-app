package com.orangeside.patchca;


import com.orangeside.patchca.color.SingleColorFactory;
import com.orangeside.patchca.encoder.EncoderHelper;
import com.orangeside.patchca.filter.predefined.CurvesRippleFilterFactory;
import com.orangeside.patchca.service.ConfigurableCaptchaService;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * sample code
 * Created by shijinkui on 15/3/15.
 */
public class Sample {
    public static void main(String[] args) throws IOException {
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        FileOutputStream fos = new FileOutputStream("patcha_demo.png");
        System.out.println(EncoderHelper.getChallangeAndWriteImage(cs, "png", fos));
        fos.close();
    }
}
