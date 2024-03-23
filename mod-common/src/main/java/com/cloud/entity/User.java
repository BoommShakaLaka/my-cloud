package com.cloud.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.apache.kafka.common.protocol.types.Field;
import org.bson.json.JsonObject;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tc_user")
public class User {
    @TableId("tc_id")
    private Integer id;
    @TableField("tc_name")
    private String name;
    @TableField("tc_age")
    private Integer age;
    @TableField("tc_sex")
    private String sex;
    @TableField("tc_college")
    private String college;
    @TableField("tc_address_info")
    private String address;
//    @JsonIgnore
    private String blocks;

    public User(Integer id, String name, String college) {
        this.id = id;
        this.name = name;
        this.college = college;
    }
}
