package com.cloud.service;

import com.cloud.entity.Material;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("cloud-order")
public interface MaterialService {
    @GetMapping("/material")
    Material queryMaterialInfo(@RequestParam("materialNo") String materialNo);

    @GetMapping("/materials")
    List<Material> queryMaterialsByCompany(@RequestParam("company") String company);
}
