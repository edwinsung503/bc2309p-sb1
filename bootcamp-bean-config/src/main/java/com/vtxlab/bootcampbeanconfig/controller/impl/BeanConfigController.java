package com.vtxlab.bootcampbeanconfig.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcampbeanconfig.controller.BeanConfigOperation;

//@Component, means the abstract representative of @Controller, @Service , @Repository
@RestController // @Controller + @ResponseBody
@RequestMapping(value ="api/v1")
public class BeanConfigController implements BeanConfigOperation {
  
  @Autowired
  private CharSequence superman;

  @Override
  public CharSequence getSuperman(){
    return this.superman;
  }
  
}
