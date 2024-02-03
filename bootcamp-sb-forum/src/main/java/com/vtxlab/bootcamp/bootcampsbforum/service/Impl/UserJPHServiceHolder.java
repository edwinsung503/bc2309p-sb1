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
    // It simplifies the communication with HTTP servers and handles the conversion of HTTP responses to Java objects. 
    String targetUrl = "https://jsonplaceholder.typicode.com/users";
    //call API 
    //1. invoke url: jsonplaceholder.typicode.com/users
    //2. deserialization (From JSON String to Java Object) -> 將value 放入object 接住
    //deserialization : process of converting data from a format suitable for storage or transmission back into an object of a specific data type
    // 變左做object -> 可以用java 去做想做的野
    User[] users = restTemplate.getForObject( targetUrl, User[].class);// return a user array -> User[].class

    //array to List
    return Arrays.stream(users)
      .collect(Collectors.toList());
  }

}
