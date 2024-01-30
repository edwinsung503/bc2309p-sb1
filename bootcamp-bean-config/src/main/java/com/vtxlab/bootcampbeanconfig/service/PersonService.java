package com.vtxlab.bootcampbeanconfig.service;

import java.util.List;
import com.vtxlab.bootcampbeanconfig.model.Person;

public interface PersonService {

  List<Person> getPersons();

  Person getPerson(int index);

  Person createPerson(Person person);

  Person deletePerson(int index);

  Person updatPerson(int index, Person person);

  Person patchPersonName (int index, String name);

  Person patchPersonAge(int index, int age);


  
}
