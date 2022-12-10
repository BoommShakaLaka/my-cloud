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
}
