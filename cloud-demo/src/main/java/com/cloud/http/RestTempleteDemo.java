package com.cloud.http;


import com.cloud.utils.JacksonUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestTempleteDemo {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("username", "jaibaoyu");
        map.put("name", "zhangsan");
        String param = JacksonUtil.writeAsJsonString(map);
        HttpEntity<String> entity = new HttpEntity<String>(param, headers);
        String result = restTemplate.postForObject("http://localhost:8888/stringFun", entity, String.class);
        System.out.println(result);
    }
}
