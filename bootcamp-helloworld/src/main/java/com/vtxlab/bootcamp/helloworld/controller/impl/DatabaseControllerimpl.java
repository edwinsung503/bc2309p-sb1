package com.vtxlab.bootcamp.helloworld.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.helloworld.controller.DatabaseController;
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
  // 只可以裝1object -> 1個impl + 1個service
  //private DatabaseServiceImpl databaseService ; 如果係咁會依靠人地的denpendcy
  //因為autowired 會自己揾
  // 因為好少用2個interface -> too complciated


  // mock databaseService.getName(index) -> "abc";
  @Override
  public String getName (int index){
    return databaseService.getName(index);
  }

  @Override
  public void setName (int index, String name){
    String n = name == null ? "xxx" : name;
    databaseService.setName(index, name);
  }
  
  @Override
  public List<String> getNames(int fromIndex, int toIndex){
    //change from array to list
    return Arrays.stream(databaseService.getNames(fromIndex,toIndex))//
      .collect(Collectors.toList());
  }

  @Override
  public void updateName (int index, String name){
    String n = name == null ? "xxx" : name;
    databaseService.setName(index, name);
  }
}
