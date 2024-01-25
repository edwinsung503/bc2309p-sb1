package com.vtxlab.bootcamp.helloworld;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface DatabaseController {
     //Notes
     //1.RequestParm & PathVariable to support Controller input params
     //2.property: required, defaultValue
     //3.URI has to be unquie(including the Path Variable)
  //@GetMapping(value = {"/db/idx/{idx}", "/db/idx"}) // part varaible
  //String getName (@PathVariable(name = "idx", required = false) int index);
//--> 可能要

  @GetMapping(value ="/db/idx/{idx}") // part varaible
  String getName (@PathVariable(name = "idx") int index);
  //如果入string -> 會爆

  @GetMapping(value = {"/db/idx/{idx}/name/{name}", "/db/idx/{idx}/name"})
  void setName(@PathVariable(name = "idx") int index,//
       @PathVariable(required = false) String name);

       
  // /api/v1/db/names?fromIdx=1&toIdx=3
  @GetMapping(value = "/db/names")
  List<String> getNames(@RequestParam(value="fromIdx", required = false, defaultValue = "0") int fromIndex, //
                        @RequestParam(value="toIdx")  int toIndex) ;
     ///api/v1/db/idx/2?name=Mary
     @GetMapping(value = "/db/update/idx/{idx}")
     void updateName(@PathVariable(name= "idx") int index,//
          @RequestParam(value = "name") String name);
  
}
