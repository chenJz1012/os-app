package com.orangeside.authorization.exception;

import com.orangeside.common.exception.BusinessException;

/**
 * Created by cgj on 2016/4/10.
 */
public class AuthBusinessException extends BusinessException{
    @Override protected String getPropertiesPath() {
        return "/config/properties/business_authorization.properties";
    }

    public AuthBusinessException(int errCode) {
        super(errCode);
    }

    public AuthBusinessException(String message) {
        super(message);
    }
}
