package com.cloud.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.annotations.RequestType;
import com.cloud.entity.Op;
import com.cloud.service.OpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class OpController {

    @Resource
    private OpService opService;

    @PostMapping("opt")
    public void saveOp(@RequestBody Map<String,String> data) {
        System.out.println(data.get("aaa"));
        Snowflake snowflake = new Snowflake();
        Op op = new Op();
        op.setFid(snowflake.nextId());
        op.setDeviceId(RandomUtil.randomString(20));
        op.setOpCode(1);
        op.setUserId(RandomUtil.randomLong(6000000000000L,7000000000000L));
        op.setExpireTime(System.currentTimeMillis());
        op.setCreateTime(System.currentTimeMillis());
        op.setUpdateTime(System.currentTimeMillis());
        opService.save(op);
    }

    @GetMapping("opt")
    public Op queryOp(@RequestParam("id") Long id) {
       return opService.getById(id);
    }

    @GetMapping("optList")
    @RequestType(value = "a",type = "aaa")
    public List<Op> queryOpByUserId(@RequestParam("userId") Long userId) {
        QueryWrapper<Op> queryWrapper = new QueryWrapper<Op>();
        queryWrapper.eq("user_id", userId);
        return opService.list(queryWrapper);
    }
}
