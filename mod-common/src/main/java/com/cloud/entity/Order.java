package com.cloud.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer orderNo;
    private Integer userId;
    private String goods;
    private Integer amount;
    private String toAdress;
    private String fromAdress;
    private Date createDate;
    private Date updateDate;
}
