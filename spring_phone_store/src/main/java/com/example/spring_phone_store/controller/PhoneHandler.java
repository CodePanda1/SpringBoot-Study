package com.example.spring_phone_store.controller;

import com.example.spring_phone_store.service.PhoneService;
import com.example.spring_phone_store.util.ResultVOUtil;
import com.example.spring_phone_store.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//JSON数据
@RequestMapping("/phone")
public class PhoneHandler {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public ResultVO index() {
        return ResultVOUtil.success(phoneService.findDataVO());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(@PathVariable("categoryType") Integer categoryType) {
        return ResultVOUtil.success(phoneService.findPhoneInfoVOByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVO findSpecsByPhoneId(@PathVariable("phoneId") Integer phoneId) {
        return ResultVOUtil.success(phoneService.findSpecsByPhoneId(phoneId));
    }
}
