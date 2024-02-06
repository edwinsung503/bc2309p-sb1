package com.vtxlab.bootcamp.bootcampdemoexception;

import com.vtxlab.bootcamp.bootcampdemoexception.Model.Cat;

public class CatService {
  
  public Cat getCat(int x) throws IllegalArgumentException{
    if (x > 10){
      throw new IllegalArgumentException();
    }
    return new Cat("john",13);
  }
}
