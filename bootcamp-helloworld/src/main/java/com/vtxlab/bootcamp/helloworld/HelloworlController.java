package com.vtxlab.bootcamp.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.helloworld.model.Cat;
import com.vtxlab.bootcamp.helloworld.model.Dog;

public interface HelloworlController {

   @GetMapping(value = "/helloworld")
   String helloworld();

   @GetMapping(value = "/sleep") 
   String sleep();

   @GetMapping(value = "/number")
    int number();

    @GetMapping(value="/char")
    char character();

    @GetMapping(value="/Integer")
    Integer integer();

    @GetMapping(value = "/cats")
    Cat cat2 ();

    @GetMapping(value = "boolean")
    boolean testBoolean ();

    @GetMapping(value = "/dog")
    Dog dog();
}