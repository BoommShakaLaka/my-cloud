package com.cloud.http;

import com.cloud.utils.JacksonUtil;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpClientDemo {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        String urlStr = "http://localhost:8888/stringFun";

        // 创建httppost对象
        HttpPost httpPost = new HttpPost(urlStr);
        // 设置请求头
        httpPost.addHeader("Content-type", "application/json");
        // 准备入参
        Map<String, String> map = new HashMap<>();
        map.put("username", "jaibaoyu");
        map.put("name", "zhangsan");
        String param = JacksonUtil.writeAsJsonString(map);
        StringEntity jsonEntity = new StringEntity(param, Consts.UTF_8);
        jsonEntity.setContentEncoding(Consts.UTF_8.name());
        httpPost.setEntity(jsonEntity);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            HttpEntity resultEntity = response.getEntity();
            String stringReuslt = EntityUtils.toString(resultEntity, StandardCharsets.UTF_8);
            System.out.println(stringReuslt);
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
