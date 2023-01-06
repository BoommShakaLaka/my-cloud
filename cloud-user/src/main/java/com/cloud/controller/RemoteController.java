package com.cloud.controller;

import com.cloud.client.MaterialFeignClent;
import com.cloud.entity.Material;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *         1.Java原生类
 *         HttpURLConnection
 *
 *         2.HttpClient
 *         apache 提供的通用工具类
 *
 *         3.Feign
 *         Spring Cloud 提供的基于Http协议的远程调用
 *
 *         4.RestTemplate
 *         Spring提供的另一个基于Http协议的远程调用
 *
 *         5.RPC
 *         各个公司内部会自研一些RPC框架，是基于TCP协议的，具体用法需见各个公司内部的开发文档
 */
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
