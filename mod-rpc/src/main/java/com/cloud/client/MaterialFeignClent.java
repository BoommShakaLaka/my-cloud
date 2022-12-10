package com.cloud.client;

import com.cloud.service.MaterialService;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(value = "cloud-order")
public interface MaterialFeignClent extends MaterialService {
}
