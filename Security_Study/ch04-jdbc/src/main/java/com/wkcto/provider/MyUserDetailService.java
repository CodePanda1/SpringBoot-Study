package com.wkcto.provider;

import com.wkcto.dao.UserInfoDao;
import com.wkcto.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoDao userInfoDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        UserInfo userInfo = null;
        if (username != null) {
            userInfo = userInfoDao.findByUsername(username);

            if (userInfo != null) {
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
                //角色必须以ROLE_开头
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + userInfo.getRole());
                grantedAuthorityList.add(grantedAuthority);

                //创建user对象
                user = new User(userInfo.getUsername(), userInfo.getPassword(), grantedAuthorityList);
            }
        }

        return user;
    }
}
