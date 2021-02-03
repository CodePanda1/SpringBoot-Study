package com.wkcto.service.impl;

import com.wkcto.dao.UserInfoDao;
import com.wkcto.entity.UserInfo;
import com.wkcto.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfo findUserInfo(String username) {
        UserInfo userInfo = userInfoDao.findByUsername(username);
        return userInfo;
    }
}
