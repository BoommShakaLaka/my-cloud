package com.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.entity.Op;
import com.cloud.mapper.OpMapper;
import com.cloud.service.OpService;
import org.springframework.stereotype.Service;

@Service
public class OpServiceImpl extends ServiceImpl<OpMapper, Op> implements OpService {

}
