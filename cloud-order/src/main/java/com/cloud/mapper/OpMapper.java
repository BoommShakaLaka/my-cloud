package com.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.entity.Op;

import java.util.List;

public interface OpMapper extends BaseMapper<Op> {

    void insertOp(Op op);

    List<Op> selectOpForUpdate();
}
