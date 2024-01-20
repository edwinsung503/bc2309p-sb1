package com.vtxlab.bootcamp.bootcamphelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import model.Superman;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v053103")
public class Hello {

  @GetMapping("/Edwin")
  public String name(){
    return "edwin";
  }
  @GetMapping("/superman")
  public Superman superman(){
    Superman superman = new Superman("Edwin", 18);
    return superman ;
  }
}
