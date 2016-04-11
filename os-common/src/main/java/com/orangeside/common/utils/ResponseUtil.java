package com.orangeside.common.utils;


import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.validation.BindingResult;

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
        return new Result(true, 200, "ok");
    }

    public static Result success(String msg) {
        return new Result(true, 200, msg);
    }

    public static <T> Result success(T data) {
        return new Result(true, 200, "ok", data);
    }

    public static Result error() {
        return new Result(false, 500, "error");
    }

    public static Result error(String msg) {
        return new Result(false, 500, msg);
    }

    public static Result error(BindingResult result) {
        String msg = "";
        if (result.hasFieldErrors()) {
            msg = result.getFieldErrors().get(0).getField() + ":" + result.getFieldError()
                .getDefaultMessage();
        }
        return new Result(false, 500, msg);
    }

    public static void error(HttpServletResponse response, String message) {
        try {
            writeJson(response, error(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
