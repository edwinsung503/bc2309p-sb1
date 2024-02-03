package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Syscode {
  
  OK("000000","OK."),
  NOTFOUND("000001","Resources not found"),;

  private String code;
  private String message;




}
