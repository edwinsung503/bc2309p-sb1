package com.vtxlab.bootcampbeanconfig.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanConfigOperation {

  @GetMapping(value = "/superman")
  String getSuperman();
}
