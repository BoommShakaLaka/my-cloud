package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String name;
    private String username;
    private Integer age;
    private Integer sex;
    private String address;

    public User(Integer userId, String name, String username) {
        this.userId = userId;
        this.name = name;
        this.username = username;
    }
}
