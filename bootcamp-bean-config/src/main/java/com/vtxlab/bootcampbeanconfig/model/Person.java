package com.vtxlab.bootcampbeanconfig.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Person {
  
  private String name;

  private int age;

  
  
}
