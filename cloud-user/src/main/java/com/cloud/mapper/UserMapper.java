package com.cloud.mapper;

import com.cloud.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserById(@Param("userId") Integer id);
}
