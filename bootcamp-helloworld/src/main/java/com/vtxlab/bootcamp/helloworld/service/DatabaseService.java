package com.vtxlab.bootcamp.helloworld.service;

public interface DatabaseService {

  //service 係對內
  String getName(int index);
  
  //for business logic
  void setName(int index, String name);
}
