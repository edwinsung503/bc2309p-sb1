package com.vtxlab.bootcamp.bootcampsbforum.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service  
public class UserJPHServiceHolder implements UserService{

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.users}")
  private String usersUri;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<User> getUsers(){
    
    //RestTemplate restTemplate = new RestTemplate();
    // It simplifies the communication with HTTP servers and handles the conversion of HTTP responses to Java objects. 
    //String targetUrl = "https://jsonplaceholder.typicode.com/users";
    //call API 
    //1. invoke url: jsonplaceholder.typicode.com/users
    //2. deserialization (From JSON String to Java Object) -> 將value 放入object 接住
    //deserialization : process of converting data from a format suitable for storage or transmission back into an object of a specific data type
    // 變左做object -> 可以用java 去做想做的野
    String url = BcUtil.getUrl(Scheme.HTTPS,domain, usersUri);
    User[] users = restTemplate.getForObject( url, User[].class);// return a user array -> User[].class
    //if return obejct -> User.class 
    //因為runtime exception-> 所以唔使打throw exception-> restclientexception
    //要諗哂所有可能性-> 做測試後要寫相關exception? 要做D 什麼
    //array to List
    return Arrays.stream(users)
      .collect(Collectors.toList());
  }


}
