package com.orangeside.common.utils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/7
 * 说明：
 */
public class PropertiesUtil {
    public static String get(String properties,String key){
        try {
            Resource res = new ClassPathResource(properties);
            return PropertiesLoaderUtils.loadProperties(res).getProperty(key, "未识别的业务异常");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
