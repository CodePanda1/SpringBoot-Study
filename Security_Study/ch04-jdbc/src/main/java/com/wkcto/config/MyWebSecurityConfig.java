package com.wkcto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //表示当前类是一个配置类（相当于Spring的xml配置文件文件），在这个类方法的返回值是Java对象，这些对象放到Spring容器中
@EnableWebSecurity //表示启用Spring Security安全框架的功能
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法级别的认证
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("MyUserDetailService")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
