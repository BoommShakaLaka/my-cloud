package com.cloud.mapper;

import com.cloud.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    Order queryOrderById(@Param("orderId") Long orderId);

}
