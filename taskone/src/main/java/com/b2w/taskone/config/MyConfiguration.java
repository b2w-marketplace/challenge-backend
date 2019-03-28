package com.b2w.taskone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfiguration {

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}