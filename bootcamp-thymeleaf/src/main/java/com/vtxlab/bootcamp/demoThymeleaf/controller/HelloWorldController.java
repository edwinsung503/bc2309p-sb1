package com.vtxlab.bootcamp.demoThymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //return html format
@RequestMapping(value ="/api/v1")
public class HelloWorldController {

  ///api/v1/greeting
  @GetMapping (value ="/greeting")
  public String hello(Model model){ //pass by refernce
    model.addAttribute("tutor", "Edwin");
    return "helloworld";
  }
}
