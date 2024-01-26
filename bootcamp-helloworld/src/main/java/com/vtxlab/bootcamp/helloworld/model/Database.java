package com.vtxlab.bootcamp.helloworld.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
  
  private static final int dbLength = 100 ;
  private static String [] strings = new String[dbLength] ;

  static {
    strings[0] = "Peter";
    strings[1] = "John";
  }

  public static void setString (int index, String string) {
    if ( index < 0 || index > dbLength - 1) 
      throw new IllegalArgumentException();
    strings[index] = string;
  }

  public static String getString (int index) {
    if ( index < 0 || index > dbLength - 1) 
      throw new IllegalArgumentException();
    return strings[index];
  }
  //
  public static String[] getNames(int fromIdx, int toIdx){
    if ( fromIdx < 0 || fromIdx > dbLength - 1 || //
    toIdx < 0 || toIdx > dbLength - 1 || //
    fromIdx > toIdx  ) 
      throw new IllegalArgumentException();
    String [] names = new String[toIdx - fromIdx + 1] ;
    int idx = 0;
    for (int i= fromIdx ; i< toIdx + 1; i++){
      names[idx++] = strings[i];
    }
    return names;
  }

}
