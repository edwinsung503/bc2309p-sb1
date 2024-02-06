package com.vtxlab.bootcamp.bootcampdemoexception;

import com.vtxlab.bootcamp.bootcampdemoexception.Model.Cat;

public class CatController {
    public Cat getCat() throws IllegalArgumentException{
    try{
      Cat cat =  new CatService().getCat(11);  //exception
      System.out.println("after call");
      return cat;
    } catch (IllegalArgumentException e) {
      return null;
    }
  }
  //java only return or throw
  public static void main(String[] args) {
    System.out.println(new CatController().getCat());
  }
}
