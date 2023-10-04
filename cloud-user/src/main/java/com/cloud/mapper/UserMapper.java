package com.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Cacheable(unless = "#result == null", cacheManager = "springCacheManager",value = "user", key = "#a0")
    User queryUserById(@Param("userId") Integer id);


    @Cacheable(unless = "#result == null", cacheManager = "redisCacheManager",value = "user")
    User queryUserByName(@Param("name") String name);
}
