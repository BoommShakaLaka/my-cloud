package com.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageController {
    @GetMapping("manage")
    public String getManage(@RequestParam("name") String name) {
        return "this is manage info";
    }
}
