package com.example.spring_phone_store.service.impl;

import com.example.spring_phone_store.entity.PhoneCategory;
import com.example.spring_phone_store.entity.PhoneInfo;
import com.example.spring_phone_store.repository.PhoneCategoryRepository;
import com.example.spring_phone_store.repository.PhoneInfoRepository;
import com.example.spring_phone_store.service.PhoneService;
import com.example.spring_phone_store.util.PhoneUtil;
import com.example.spring_phone_store.vo.DataVO;
import com.example.spring_phone_store.vo.PhoneCategoryVO;
import com.example.spring_phone_store.vo.PhoneInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;

    @Override
    public DataVO findDataVO() {
        DataVO dataVO = new DataVO();
        //类型
        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();

        //常规写法
//        List<PhoneCategoryVO> phoneCategoryVOList = new ArrayList<>();
//        for (PhoneCategory phoneCategory : phoneCategoryList) {
//            PhoneCategoryVO phoneCategoryVO = new PhoneCategoryVO();
//            phoneCategoryVO.setCategoryName(phoneCategory.getCategoryName());
//            phoneCategoryVO.setCategoryType(phoneCategory.getCategoryType());
//            phoneCategoryVOList.add(phoneCategoryVO);
//        }
        //stream  JDK8新特性
        List<PhoneCategoryVO> phoneCategoryVOList = phoneCategoryList.stream()
                .map(e -> new PhoneCategoryVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());
        dataVO.setCategories(phoneCategoryVOList);

        //手机
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(phoneCategoryList.get(0).getCategoryType());

        //常规写法
//        List<PhoneInfoVO>phoneInfoVOList=new ArrayList<>();
//        for (PhoneInfoVO phoneInfoVO : phoneInfoVOList) {
//            PhoneInfo phoneInfo=new PhoneInfo();
//            BeanUtils.copyProperties(phoneInfo,phoneInfoVO);//Spring方法 直接复制 省去set
//            phoneInfoVO.setTag(PhoneUtil.createTag(phoneInfo.getPhoneTag()));
//        }
        //stream
        List<PhoneInfoVO> phoneInfoVOList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice(),
                        e.getPhoneDescription(),
                        e.getPhoneIcon(),
                        PhoneUtil.createTag(e.getPhoneTag())
                )).collect(Collectors.toList());
        dataVO.setPhones(phoneInfoVOList);

        return dataVO;
    }
}
