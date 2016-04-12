package com.orangeside.patchca;


import com.orangeside.patchca.color.SingleColorFactory;
import com.orangeside.patchca.encoder.EncoderHelper;
import com.orangeside.patchca.filter.predefined.*;
import com.orangeside.patchca.service.ConfigurableCaptchaService;

import java.awt.*;
import java.io.FileOutputStream;

public class PatchcaFilterDemoPNG {

	public static void main(String[] args) throws Exception {
		for (int counter = 0; counter < 5; counter++) {
			ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
			cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
			switch (counter % 5) {
			case 0:
				cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
				break;
			case 1:
				cs.setFilterFactory(new MarbleRippleFilterFactory());
				break;
			case 2:
				cs.setFilterFactory(new DoubleRippleFilterFactory());
				break;
			case 3:
				cs.setFilterFactory(new WobbleRippleFilterFactory());
				break;
			case 4:
				cs.setFilterFactory(new DiffuseRippleFilterFactory());
				break;
			}
			FileOutputStream fos = new FileOutputStream("patcha_demo" + counter + ".png");
			EncoderHelper.getChallangeAndWriteImage(cs, "png", fos);
			fos.close();
		}
	}
}