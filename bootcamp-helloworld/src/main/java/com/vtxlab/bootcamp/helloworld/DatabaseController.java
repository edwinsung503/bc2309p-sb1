package com.vtxlab.bootcamp.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DatabaseController {

  @GetMapping(value = "/db/idx/{idx}") // part varaible
  String getName (@PathVariable(name = "idx") int index);
  //如果入string -> 會爆

  @GetMapping(value = "/db/idx/{idx}/name/{name}")
  void setName(@PathVariable(name = "idx") int index, //
      @PathVariable String name);
  
}
