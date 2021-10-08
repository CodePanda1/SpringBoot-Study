package com.dev.dataviewspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dev.dataviewspring.entity.VUserLoginEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VUserLoginMapper extends BaseMapper<VUserLoginEntity> {
    List<VUserLoginEntity> userLoginList();
}
