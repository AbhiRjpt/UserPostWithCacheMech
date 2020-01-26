package com.ranag.config;

import com.ranag.service.RequestValidationService;
import com.ranag.service.RestResponseService;
import com.ranag.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConf {
    @Bean
    public RestResponseService restResponseService(){
        return new RestResponseService();
    }

    @Bean
    public RequestValidationService requestValidationService(){
        return new RequestValidationService();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

}
