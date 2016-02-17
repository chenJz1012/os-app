package com.orangeside.common.exception;

import com.orangeside.common.utils.PropertiesUtil;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/7
 * 说明：
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 4793699346343027629L;
    private String PROPERTIES = "/config/properties/business_exception.properties";
    private String err = "";
    public BusinessException(int errCode) {
        this.err = PropertiesUtil.get(PROPERTIES, String.valueOf(errCode));
    }
    @Override
    public String getMessage() {
        return this.err;
    }
}
