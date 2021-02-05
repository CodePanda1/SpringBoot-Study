package com.wkcto.init;

import com.wkcto.dao.UserInfoDao;
import com.wkcto.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class JKdbcInit {

    @Autowired
    private UserInfoDao userInfoDao;

//    @PostConstruct
//    public void init() {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("zhangsan");
//        userInfo.setPassword(passwordEncoder.encode("123456"));
//        userInfo.setRole("normal");
//        userInfoDao.save(userInfo);
//
//        userInfo = new UserInfo();
//        userInfo.setUsername("admin");
//        userInfo.setPassword(passwordEncoder.encode("admin"));
//        userInfo.setRole("admin");
//        userInfoDao.save(userInfo);
//    }
}
