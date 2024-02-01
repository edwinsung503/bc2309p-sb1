package com.vtxlab.bootcamp.helloworld.controller;

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
                        @RequestParam(value="toIdx")  int toIndex);
     //@RequestParam 是一个用于处理HTTP请求参数的Spring注解。它将请求参数绑定到你的控制器方法参数上。
     //例如，在一个HTTP GET请求中，你可以使用@RequestParam注解获取查询参数的值。
     //參數係來自user
     //if the form 有好多paramter 要填->用RequestParam 

     ///api/v1/db/idx/2?name=Mary
     @GetMapping(value = "/db/update/idx/{idx}")
     void updateName(@PathVariable(name= "idx") int index,//
          @RequestParam(value = "name") String name);
  
}
