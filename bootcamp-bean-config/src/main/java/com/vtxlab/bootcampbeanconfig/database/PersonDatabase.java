package com.vtxlab.bootcampbeanconfig.database;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.bootcampbeanconfig.model.Person;

public class PersonDatabase {
  
  private static final List<Person> persons;// static -> 會係個server 除非死機
  //private static final List<Person> persons; -> final 左個address 唔可以再new 多次個
  //persons = new ArrayList<>();
  static {
    persons = new ArrayList<>();
  }

  public static List<Person> getPersons(){
    return persons;
  }
  public static Person getPerson(int index){
    return persons.get(index);
  }

  public static void setPerson (int index, Person person){
    persons.set(index, person);
  }
}
