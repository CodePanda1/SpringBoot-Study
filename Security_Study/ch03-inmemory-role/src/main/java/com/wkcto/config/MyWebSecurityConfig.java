package com.wkcto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //表示当前类是一个配置类（相当于Spring的xml配置文件文件），在这个类方法的返回值是Java对象，这些对象放到Spring容器中
@EnableWebSecurity //表示启用Spring Security安全框架的功能
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    //在方法中配置用户名和密码，作为登录信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pe = passwordEncoder();

        auth.inMemoryAuthentication().withUser("zhangsan").password(pe.encode("123")).roles();
        auth.inMemoryAuthentication().withUser("lisi").password(pe.encode("321")).roles();
        auth.inMemoryAuthentication().withUser("admin").password(pe.encode("admin")).roles();
    }

    //创建密码的加密类
    @Bean //把方法返回值的对象，放入Spring容器中
    public PasswordEncoder passwordEncoder(){
        //创建passwordEncoder的实现类，实现加密算法
        return new BCryptPasswordEncoder();
    }
}
