package com.cloud.service.impl;

import com.cloud.entity.Material;
import com.cloud.service.MaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class MateriaServiceImpl implements MaterialService {


    @Override
    public List<Material> queryMaterialsByCompany(String company) {
        log.info("MateriaServiceImpl#queryMaterialsByCompany:{}", company);
        return Arrays.asList(new Material(100001, "红酒", "荣国府"),
                new Material(100002, "白酒酒", "宁国府"));
    }
    
    @Override
    public Material queryMaterialInfo(String materialNo) {
        return new Material(100002, "白酒酒", "大观园");
    }
}
