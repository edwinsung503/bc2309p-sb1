package com.vtxlab.bootcamp.bootcampsbforum.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.RedisHelper;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.User2;
import com.vtxlab.bootcamp.bootcampsbforum.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService{
  
  // @Autowired
  // private RedisTemplate<String,String> redisTemplate;
  @Autowired
  private RedisHelper redisHelper;

  @Override
  public User2 creatUser2(String key, User2 user2) throws JsonProcessingException{
    //user -> json(String)
    //Object mapper 
    //ObjectMapper objectMapper = new ObjectMapper();
    //String serilized = objectMapper.writeValueAsString(user2);
    //redisTemplate.opsForValue().set(key, serilized);
    redisHelper.set(key, user2);
    return user2;
  }

}
