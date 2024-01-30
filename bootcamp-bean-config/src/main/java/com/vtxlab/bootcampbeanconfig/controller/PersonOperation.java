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
  
  @PostMapping(value = "/person")
  Person createPerson(@RequestBody Person person);//Object 睇成person

  @DeleteMapping(value = "/person/{idx}")
  Boolean deletePerson (@PathVariable (name ="idx") int index);

  @PutMapping(value = "/person/{idx}")
  Person updatePerson (@PathVariable int index, @RequestBody Person person);

  @PatchMapping(value = "/person/{idx}/name/{name}")//存在先update 佢
  Person patchPersonName (@PathVariable int index, @PathVariable String name);

  @PatchMapping(value = "/person/{idx}/age/{age}")//存在先update 佢
  Person patchPersonAge (@PathVariable int index, @PathVariable int age);


}
