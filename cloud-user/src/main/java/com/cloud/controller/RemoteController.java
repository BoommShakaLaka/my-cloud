package com.cloud.controller;

import com.cloud.entity.Material;
import com.cloud.service.MaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RemoteController {
    //    @Resource
//    RestTemplate restTemplate;
//    @Resource
//    HttpClient httpClient;
    @Resource
    MaterialService materialService;
//    @Resource
//    MaterialService materialService;

    @GetMapping("/restTempate")
    public List<Material> fun1() {
        return materialService.queryMaterialsByCompany("aaaa");
    }

    @GetMapping("/restTempate2")
    public Material fun2() {
        return materialService.queryMaterialInfo("aaaa");
    }

}
