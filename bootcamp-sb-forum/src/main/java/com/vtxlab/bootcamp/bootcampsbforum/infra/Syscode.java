package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Syscode {
  OK("000000", "OK."), //
  NOTFOUND("000001", "Resource Not Found"),
  REST_CLIENT_EXCEPTION("90001","RestClientExcpetion"),
  NULL_POINTER_EXCEPTION("90002","NPE"),
  GENERAL_EXCEPTION("90003","AllArgurmentException");


  private String code;
  private String message;

}
