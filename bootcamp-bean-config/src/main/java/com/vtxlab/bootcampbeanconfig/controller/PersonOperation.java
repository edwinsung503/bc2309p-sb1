package com.vtxlab.bootcampbeanconfig.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.bootcampbeanconfig.model.Person;

public interface PersonOperation {

  @GetMapping(value = "/persons")
  List<Person> getPersons();

  @GetMapping(value = "/person/{idx}")
  Person getPerson(@PathVariable (name="idx") int index);
  
  //create a new resource.
  @PostMapping(value = "/person")
  Person createPerson(@RequestBody Person person);//Object 睇成person

  @DeleteMapping(value = "/person/{idx}")
  Boolean deletePerson (@PathVariable (name ="idx") int index);

  //update or replace an existing resource. 
  @PutMapping(value = "/person/{idx}")
  Person updatePerson (@PathVariable int idx, @RequestBody Person person);
  //@RequestBody: read the body content of the request and deserialize it into an object

  //apply partial modifications to a resource.
  @PatchMapping(value = "/person/{idx}/name/{name}")//存在先update 佢
  Person patchPersonName (@PathVariable int idx, @PathVariable String name);

  @PatchMapping(value = "/person/{idx}/age/{age}")
  Person patchPersonAge (@PathVariable int idx, @PathVariable int age);


}
