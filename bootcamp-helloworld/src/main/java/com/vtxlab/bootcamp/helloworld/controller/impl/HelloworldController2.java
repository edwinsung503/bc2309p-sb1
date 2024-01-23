package com.vtxlab.bootcamp.helloworld.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.helloworld.model.Dog;
import com.vtxlab.bootcamp.helloworld.model.Fish;

@Controller
@ResponseBody
@RequestMapping( value ="/api/v2")
public class HelloworldController2 {
  @GetMapping("/helloworld")
  public String helloworld(){
    return "helloworld. Version 2";
  }

  @GetMapping("/dog")
  public Dog dog (){
    return new Dog("Peter");
  }

  @GetMapping("/fish")
  public Fish fish(){
    List<String> descriptions = new ArrayList<>();
    descriptions.add("I am sleeping");
    descriptions.add("I am playing");
    Fish fish = new Fish("John",descriptions);
    return fish;

  }
}
