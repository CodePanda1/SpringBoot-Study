package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.entity.BuyerAddress;
import com.example.spring_phone_store.from.AddressFrom;
import com.example.spring_phone_store.repository.BuyerAddressRepository;
import com.example.spring_phone_store.service.AddressService;
import com.example.spring_phone_store.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    @Override
    public List<AddressVO> findAll() {
        List<AddressVO> list = buyerAddressRepository.findAll().stream()
                .map(e -> new AddressVO(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());
        return list;
    }

    @Override
    public void saveOrUpdate(AddressFrom addressFrom) {
        BuyerAddress buyerAddress;
        if (addressFrom.getId() == null) {
            buyerAddress = new BuyerAddress();
        } else {
            buyerAddress = buyerAddressRepository.findById(addressFrom.getId()).get();
        }
        buyerAddress.setBuyerName(addressFrom.getName());
        buyerAddress.setBuyerPhone(addressFrom.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressFrom.getProvince())
                .append(addressFrom.getCity())
                .append(addressFrom.getCounty())
                .append(addressFrom.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressFrom.getAreaCode());

        buyerAddressRepository.save(buyerAddress);
    }
}
