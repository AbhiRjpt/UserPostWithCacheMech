package com.ranag.config;


import com.ranag.dao.impl.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public UserDaoImpl userDao(){
        return new UserDaoImpl();
    }

}
