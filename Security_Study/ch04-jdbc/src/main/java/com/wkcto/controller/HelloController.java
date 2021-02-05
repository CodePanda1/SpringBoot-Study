package com.wkcto.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "使用内存中的用户信息";
    }

    //指定都可以访问的方法
    @RequestMapping("/helloUser")
    @PreAuthorize(value = "hasAnyRole('admin','normal')")
    public String helloCommonUser() {
        return "qwenormal admin都可访问";
    }

    @RequestMapping("/helloAdmin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String helloAdmin() {
        return "qwe仅限于admin";
    }
}
