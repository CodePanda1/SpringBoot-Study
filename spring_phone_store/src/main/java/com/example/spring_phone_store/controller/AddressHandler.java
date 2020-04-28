package com.example.spring_phone_store.controller;

import com.example.spring_phone_store.exception.PhoneException;
import com.example.spring_phone_store.from.AddressFrom;
import com.example.spring_phone_store.service.AddressService;
import com.example.spring_phone_store.util.ResultVOUtil;
import com.example.spring_phone_store.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressHandler {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResultVO list() {
        return ResultVOUtil.success(addressService.findAll());
    }

    //@Valid验证   @RequestBody把Json数据解析为Java对象
    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody AddressFrom addressFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【添加地址】参数错误,addressFrom{}", addressFrom);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressFrom);

        return ResultVOUtil.success(null);
    }

    @PutMapping("/update")
    public ResultVO update(@Valid @RequestBody AddressFrom addressFrom, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【修改地址】参数错误,addressFrom{}", addressFrom);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressFrom);

        return ResultVOUtil.success(null);
    }
}
