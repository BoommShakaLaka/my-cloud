package com.cloud.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cfs_op")
public class Op {

    @TableId
    private long fid;
    private long userId;
    private int opCode;
    private String deviceId;
    private long expireTime;
    private long updateTime;
    private long createTime;
}
