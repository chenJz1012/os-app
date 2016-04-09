package com.orangeside.common.utils;


import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/6
 * 说明：
 */
public class ResponseUtil {
    public static Map<String, Object> fail(String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        map.put("message", message);
        return map;
    }

    public static void fail(HttpServletResponse response, String message) {
        try {
            Map<String, Object> map = fail(message);
            writeJson(response, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJson(HttpServletResponse response, Object o) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        JsonGenerator jsonGenerator = objectMapper.getJsonFactory()
            .createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
        objectMapper.writeValue(jsonGenerator, o);
    }

    public static void writeJson(HttpServletResponse response, boolean success, Integer code,
        String message, String targetUrl) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", success);
        if (code != null)
            map.put("code", code);
        map.put("message", message);
        if (targetUrl != null)
            map.put("targetUrl", targetUrl);
        writeJson(response, map);
    }

    public static Result success() {
        return new Result(true, "success");
    }

    public static Result success(String msg) {
        return new Result(true, msg);
    }

    public static <T> Result success(T data) {
        return new Result(true, "ok", data);
    }

    public static Result error() {
        return new Result(false, "error");
    }

    public static Result error(String msg) {
        return new Result(false, msg);
    }

}
