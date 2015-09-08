package com.orangeside.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/8
 * 说明：
 */
public class RequestUtil {
    public static boolean isAjax(HttpServletRequest request) {
        String head = request.getHeader("X-Requested-With");
        if (StringUtils.isNotBlank(head) && "XMLHttpRequest".equals(head))
            return true;
        return false;
    }
}
