package com.vtxlab.bootcamp.bootcampsbforum.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class UserJPHServiceHolder implements UserService{
  

  @Override
  public List<User> getUsers(){
    
    RestTemplate restTemplate = new RestTemplate();
    String targetUrl = "https://jsonplaceholder.typicode.com/users";
    //call API 
    //1. invoke jsonplaceholder.typicode.com/users
    //2. deserialization (From JSON String to Java Object) -> 接住d value
    User[] users = restTemplate.getForObject( targetUrl, User[].class);// return a user array -> User[].class

    //array to List
    return Arrays.stream(users)
      .collect(Collectors.toList());
  }

}
