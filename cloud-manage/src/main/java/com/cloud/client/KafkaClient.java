package com.cloud.client;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaClient {
/*
springboot 项目集成了Kafka,如果nacos和@KafkaListener中都配置了groupId,哪个优先级高
如果在Spring Boot项目中集成了Kafka，并且同时在Nacos配置和@KafkaListener注解中都配置了groupId，则以@KafkaListener注解中的配置为准。
这是因为@KafkaListener注解指定的groupId用于标识消费者组，在同一个消费者组中，每个消费者实例只能消费该组中的某个分区。
而在Nacos配置中指定的groupId通常用于配置中心等场景，用于标识不同的配置集合。
因此，在使用@KafkaListener注解时，Nacos配置中的groupId并不会影响消费者的消费行为。
需要注意的是，如果在代码中同时指定了多个@KafkaListener注解，并且每个注解中都配置了groupId，则每个注解都会创建一个独立的消费者组。
这意味着同一个消息会被多个消费者组中的消费者消费，可能会导致重复消费等问题。因此，在使用@KafkaListener注解时，应确保每个注解中的groupId是唯一的，并且同一个消费者组中的消费者数量不要超过分区数。
 */


/*    @KafkaListener(groupId = "my-group2",
            containerFactory = "kafkaPrimaryListenerContainerFactory",
            topics = "my_topic")*/

    @KafkaListener(containerFactory = "kafkaPrimaryListenerContainerFactory", topics = "my_topic")
    public void consumerMessage(ConsumerRecord record) {
        System.out.println(record.value());
    }


    @KafkaListener(containerFactory = "kafkaPrimaryListenerContainerFactory", topics = "my_topic")
    public void consumerMessage1(ConsumerRecord record) {
        System.out.println(record.value());
    }
}
