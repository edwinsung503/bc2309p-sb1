package com.vtxlab.bootcamp.helloworld.model;

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
}
