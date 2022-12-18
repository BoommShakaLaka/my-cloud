package com.cloud.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String college;
    private String address;

    public User(Integer id, String name, String college) {
        this.id = id;
        this.name = name;
        this.college = college;
    }
}
