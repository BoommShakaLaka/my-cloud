package com.cloud.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Async("baseThreadPool")
    public void testThread() {
        System.out.println(Thread.currentThread().getName());
    }
}
