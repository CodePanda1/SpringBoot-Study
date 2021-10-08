package com.dev.dataviewspring.controller;

import com.dev.dataviewspring.service.MService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MController {

    @Autowired
    private MService mService;

    @GetMapping("qqq")
    public List qwe() {
        return mService.VChannelnoList();
    }

    @GetMapping("list")
    public List userLoginList() {

        return mService.userLoginList();
    }
}
