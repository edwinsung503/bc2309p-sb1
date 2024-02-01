package com.vtxlab.bootcampbeanconfig.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
//generates boilerplate code such as 
//getters and setters, equals(), hashCode(), and toString() methods
@NoArgsConstructor
@Builder
public class Person {
  
  private String name;

  private int age;

  
  
}
