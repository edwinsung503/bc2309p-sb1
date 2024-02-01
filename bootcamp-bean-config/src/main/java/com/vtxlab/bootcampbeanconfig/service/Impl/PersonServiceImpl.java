package com.vtxlab.bootcampbeanconfig.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcampbeanconfig.database.PersonDatabase;
import com.vtxlab.bootcampbeanconfig.model.Person;
import com.vtxlab.bootcampbeanconfig.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

  @Override
  public List<Person> getPersons(){
    return PersonDatabase.getPersons();
  }

  @Override
  public Person getPerson(int index){
    return PersonDatabase.getPerson(index);
  }

  @Override
  public Person createPerson(Person person){
    if(PersonDatabase.getPersons().add(person)){
      return person;
    }
    return null;
  }

  @Override
  public Person deletePerson(int index){
    return PersonDatabase.getPersons().remove(index);
  }

  @Override
  public Person updatPerson(int index, Person person){
    return PersonDatabase.getPersons().set(index, person);
  }

  @Override
  public Person patchPersonName(int index, String name){
    Person person = getPerson(index);
    if (person != null){
      person.setName(name);
      return person;
    }
    return null;
  }

  @Override
  public Person patchPersonAge (int index, int age){
    Person person = getPerson(index);
    if (person != null){
      person.setAge(age);
      return person;
    }
    return null;
  }

}
