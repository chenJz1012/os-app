package com.orangeside.sample.exception;

import com.orangeside.common.exception.BusinessException;

/**
 * Created by cgj on 2016/4/10.
 */
public class SampleBusinessException extends BusinessException {


    @Override
    protected String getPropertiesPath() {
        return "/config/properties/business_sample.properties";
    }

    public SampleBusinessException(int errCode) {
        super(errCode);
    }

    public SampleBusinessException(String message) {
        super(message);
    }
}
