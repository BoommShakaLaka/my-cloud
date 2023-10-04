package com.cloud.entity;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class Block {
    private Integer order;
    private String objectKey;
    private Integer size;
    private Integer locationId;
}
