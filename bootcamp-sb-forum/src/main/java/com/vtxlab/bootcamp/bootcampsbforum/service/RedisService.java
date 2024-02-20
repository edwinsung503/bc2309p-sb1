package com.vtxlab.bootcamp.bootcampsbforum.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.User2;

public interface RedisService {

 User2 creatUser2(String key, User2 user2) throws JsonProcessingException;
  
}
