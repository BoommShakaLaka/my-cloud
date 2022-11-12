package com.cloud.client;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaClient {

    @KafkaListener(groupId = "my-groupId",
            containerFactory = "kafkaPrimaryListenerContainerFactory",
            topics = "myTopic")
    public void consumerMessage(ConsumerRecord record) {
        System.out.println(record.value());
    }
}
