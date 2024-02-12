package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  
  @Bean // 可以重用的bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

}
