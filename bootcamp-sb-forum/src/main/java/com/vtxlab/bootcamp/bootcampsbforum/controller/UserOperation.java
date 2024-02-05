package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import javax.swing.Spring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {
  
  @GetMapping(value = "/users")
  List<User> getUsers();

  //@GetMapping(value = "/user") //request param
  //User getUser(@RequestParam (value = "id") int userId);
  //This is a method declaration in a Spring MVC controller class in Java.

  //- `@GetMapping(value = "/user")` is an annotation that 
  //maps HTTP GET requests onto specific handler methods. 
  //In this case, it is mapping to the URL path "/user". 
  //When a GET request is made to this URL, Spring MVC will call this handler method.
  //- `User getUser(@RequestParam (value = "id") int userId);`
  // is the method being mapped. This method is called `getUser` 
  //and it returns an instance of the `User` class.
  //- `@RequestParam (value = "id") int userId` 
  //is a method parameter annotation used 
  //to bind the value of the HTTP request parameter named "id" 
  //to the `userId` method parameter. When a request is made, 
  //the "id" parameter in the URL will be passed to 
  //the `getUser` method as the `userId` argument.
  
}
