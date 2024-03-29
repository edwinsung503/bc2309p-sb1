package com.vtxlab.bootcamp.helloworld.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.bootcamp.helloworld.model.Superman;

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
