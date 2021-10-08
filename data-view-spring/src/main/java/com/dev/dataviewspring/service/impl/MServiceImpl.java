package com.dev.dataviewspring.service.impl;

import com.dev.dataviewspring.entity.VChannelnoEntity;
import com.dev.dataviewspring.entity.VUserLoginEntity;
import com.dev.dataviewspring.mapper.VChannelnoMapper;
import com.dev.dataviewspring.mapper.VUserLoginMapper;
import com.dev.dataviewspring.service.MService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MServiceImpl implements MService {

    @Autowired
    private VChannelnoMapper vChannelnoMapper;
    @Autowired
    private VUserLoginMapper vUserLoginMapper;

    @Override
    public List VChannelnoList() {
        List<VChannelnoEntity> vChannelnoEntities = vChannelnoMapper.selectList(null);

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();

        for (VChannelnoEntity vChannelnoEntity : vChannelnoEntities) {
            strings.add(vChannelnoEntity.getChannelname());
            integers.add(vChannelnoEntity.getNum());
        }

        ArrayList<List> lists = new ArrayList<>();
        lists.add(strings);
        lists.add(integers);

        return lists;
    }

    @Override
    public List<VUserLoginEntity> userLoginList() {
        return vUserLoginMapper.userLoginList();
    }
}
