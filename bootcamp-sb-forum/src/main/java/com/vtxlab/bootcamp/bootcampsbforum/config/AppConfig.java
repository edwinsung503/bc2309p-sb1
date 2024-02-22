package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.RedisHelper;

//生2隻object , 如果起唔到object (Bean) 會死
@Configuration
public class AppConfig {
  
  @Bean // 可以重用的bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
  //要寫個format key & value
  //@Bean
  //RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
  //  RedisTemplate<String,String> redisTemplate = new RedisTemplate<>(); // empty constructor 係redis 係入面有好多野running
  //  //must neeed below three script
  //  redisTemplate.setConnectionFactory(factory);
  //  redisTemplate.setKeySerializer(RedisSerializer.string());
  //  redisTemplate.setValueSerializer(RedisSerializer.json());
  //  return redisTemplate;
  //}
  
  @Bean
  ObjectMapper objectMapper(){
    return new ObjectMapper();
  }
  @Bean
  RedisHelper redisHelper(RedisConnectionFactory factory, ObjectMapper objectMapper){
    return new RedisHelper(factory, objectMapper);
  }
  

}
