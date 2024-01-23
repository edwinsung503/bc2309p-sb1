package com.vtxlab.bootcamp.helloworld.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.helloworld.DatabaseController;
import com.vtxlab.bootcamp.helloworld.service.DatabaseService;
import com.vtxlab.bootcamp.helloworld.service.impl.DatabaseServiceimpl;

@RestController
@RequestMapping (value = "/api/v1")
public class DatabaseControllerimpl implements DatabaseController{
    
  //JVM
  //step 1(before server started)
  // Before service started
  //SpringContext, separate memory pool storing another set of objects
  //SpringContext Created when server starts ->
  //@RestController & @Service -> produce  a controller & service object 
  //唔會儲 state 

  @Autowired // 自動裝配
  private DatabaseService databaseService ; // interface
  //step 2 (before server start)
  //autowired will check if there is any object CAN be injected into DatabaseService(interface)

  @Override
  public String getName (int index){
    return databaseService.getName(index);
  }

  @Override
  public void setName (int index, String name){
    databaseService.setName(index, name);
  }
  
}
