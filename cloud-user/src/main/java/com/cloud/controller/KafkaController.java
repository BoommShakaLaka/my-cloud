package com.cloud.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class KafkaController {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("sentMessageToKafka")
    public void sentMessageToKafka() {
        kafkaTemplate.send("my_topic", "testKey", "my message");
    }
}
