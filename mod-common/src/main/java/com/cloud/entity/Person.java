package com.cloud.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class Person {
    @Id
    private String id;
    private String name;
    private String email;
}
