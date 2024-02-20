package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.User2;

public interface RedisOperation {
  
  @PostMapping(value = "/user2")
  User2 createUser(@RequestParam String key, @RequestParam User2 user2) throws JsonProcessingException;




}
