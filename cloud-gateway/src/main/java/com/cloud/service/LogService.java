package com.cloud.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class LogService {


    public void logRequest(String method, String path, String query) {
        System.out.println(method + " " + path + " " + query);
    }

    public void logResponse(HttpStatus statusCode, HttpHeaders headers) {
        System.out.println(statusCode + " " + headers);
    }
}
