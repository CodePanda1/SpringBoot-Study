package com.example.spring_phone_store.service;

import com.example.spring_phone_store.from.AddressFrom;
import com.example.spring_phone_store.vo.AddressVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> findAll();

    public void saveOrUpdate(AddressFrom addressFrom);
}
