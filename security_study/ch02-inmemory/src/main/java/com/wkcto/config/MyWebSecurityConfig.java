package com.wkcto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration //表示当前类是一个配置类（相当于Spring的xml配置文件文件），在这个类方法的返回值是Java对象，这些对象放到Spring容器中。
@EnableWebSecurity
public class MyWebSecurityConfig {

}
