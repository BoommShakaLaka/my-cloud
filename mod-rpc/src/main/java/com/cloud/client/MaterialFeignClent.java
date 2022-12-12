package com.cloud.client;

import com.cloud.service.MaterialService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(primary = false, value = "cloud-order")
public interface MaterialFeignClent extends MaterialService {
}
