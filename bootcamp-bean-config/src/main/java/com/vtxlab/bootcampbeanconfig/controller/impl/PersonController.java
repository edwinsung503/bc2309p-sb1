package com.vtxlab.bootcampbeanconfig.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcampbeanconfig.controller.PersonOperation;
import com.vtxlab.bootcampbeanconfig.model.Person;
import com.vtxlab.bootcampbeanconfig.service.PersonService;

@RestController
@RequestMapping(value = "/api/v2")
public class PersonController implements PersonOperation {
  
  @Autowired
  private PersonService personService;

  @Override
  public List<Person> getPersons(){
    return personService.getPersons();
  }

  @Override
  public Person getPerson(int index){
    return personService.getPerson(index);
  }

  @Override
  public Person createPerson (Person person){
    return personService.createPerson(person);
  }
  
  @Override
  public Boolean deletePerson(int index){
    try {
      return personService.deletePerson(index) !=null;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  @Override
  public Person updatePerson(int index, Person person){
    return personService.updatPerson(index, person);
  }

  @Override
  public Person patchPersonName(int index,String name){
    return personService.patchPersonName(index, name);
  }

  @Override
  public Person patchPersonAge(int index, int age){
    return personService.patchPersonAge(index, age);
  }
}
