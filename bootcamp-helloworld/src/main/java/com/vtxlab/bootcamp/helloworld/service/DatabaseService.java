package com.vtxlab.bootcamp.helloworld.service;

import java.util.List;

public interface DatabaseService {

  //service 係對內
  String getName(int index);
  
  //for business logic
  void setName(int index, String name);

  String [] getNames(int fromIdx, int toIdx);
}
