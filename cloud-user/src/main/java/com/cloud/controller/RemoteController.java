package com.cloud.controller;

import com.cloud.client.MaterialFeignClent;
import com.cloud.entity.Material;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RemoteController {

    @Resource
    MaterialFeignClent materialFeignClent;

    @GetMapping("/restTempate")
    public List<Material> fun1() {
        return materialFeignClent.queryMaterialsByCompany("aaaa");
    }

    @GetMapping("/restTempate2")
    public Material fun2() {
        return materialFeignClent.queryMaterialInfo("aaaa");
    }

}
