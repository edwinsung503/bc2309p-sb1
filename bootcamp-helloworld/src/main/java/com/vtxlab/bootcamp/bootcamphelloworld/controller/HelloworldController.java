package com.vtxlab.bootcamp.bootcamphelloworld.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import model.Cat;
import model.Dog;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")
public class HelloworldController {

  @GetMapping(value = "/helloworld") //path
  public String helloworld(){
    //call method a

    return "Hello world. This is my first app";
  }
  @GetMapping(value = "/sleep") //path -> end point -> 一個request 去get sth
  public String sleep() {
    return "I'm Sleeping ....";
  }

  @GetMapping(value = "/number")
  public int number(){
    return 10;
  }

  @GetMapping(value="/char")
  public char character(){
      return 'a';
  }
  @GetMapping(value="/Integer")
  public Integer integer(){
      return 12;
  }
  @GetMapping(value = "/cats")
  public Cat cat2 (){
    List<String> descriptions = new ArrayList<>();
    descriptions.add("John");
    descriptions.add("Mary");
    descriptions.add("Peter");
    Cat cat = new Cat("mary",descriptions);
    return cat;
  }

  @GetMapping(value = "boolean")
  public boolean testBoolean () {
    return true;
  }
  
  @GetMapping(value = "/dog")
  public Dog dog(){
    return new Dog("Jet");
  }



}
