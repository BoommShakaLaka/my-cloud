package com.cloud.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * jackson 常用工具
 */
public class JacksonUtil {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readerFor(clazz).readValue(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeAsJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
