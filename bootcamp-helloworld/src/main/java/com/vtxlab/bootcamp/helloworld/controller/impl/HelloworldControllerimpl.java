package com.vtxlab.bootcamp.helloworld.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.helloworld.HelloworlController;
import model.Cat;
import model.Dog;

//@Controller // -> 配對 @GetMapping 
//@ResponseBody 
//Serialization: Object -> JSON/TEXT
@RestController // -> @Controller + @ResponseBody
@RequestMapping(value = "/api/v1")
public class HelloworldControllerimpl implements HelloworlController {

  //@GetMapping(value = "/helloworld") //path
  @Override
  public String helloworld(){
    //call method a
    return "Hello world. This is my first app";
  }
  
  //@GetMapping(value = "/sleep") //path -> end point -> 一個request 去get sth
  @Override
  public String sleep() {
    return "I'm Sleeping ....";
  }

  //@GetMapping(value = "/number")
  @Override
  public int number(){
    return 10;
  }

  //@GetMapping(value="/char")
  @Override
  public char character(){
      return 'a';
  }
  //@GetMapping(value="/Integer")
  @Override
  public Integer integer(){
      return 12;
  }
  //@GetMapping(value = "/cats")
  @Override
  public Cat cat2 (){
    List<String> descriptions = new ArrayList<>();
    descriptions.add("John");
    descriptions.add("Mary");
    descriptions.add("Peter");
    Cat cat = new Cat("mary",descriptions);
    

    return cat;
  }

  //@GetMapping(value = "boolean")
  @Override
  public boolean testBoolean () {
    return true;
  }
  
  //@GetMapping(value = "/dog")
  @Override
  public Dog dog(){
    return new Dog("Jet");
  }



}
