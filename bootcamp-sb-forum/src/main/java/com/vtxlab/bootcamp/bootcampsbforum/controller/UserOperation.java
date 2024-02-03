package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {
  
  @GetMapping(value = "/users")
  List<User> getUsers();

  @GetMapping(value = "/user") //request param
  User getUser(@RequestParam (value = "id") int userId);

  
}
