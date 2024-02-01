package com.vtxlab.bootcampbeanconfig;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcampbeanconfig.controller.impl.PersonController;
import com.vtxlab.bootcampbeanconfig.model.Person;
import com.vtxlab.bootcampbeanconfig.service.PersonService;

//唔放public ->唔俾人call
//@SpringBootTest // full set of beans
@WebMvcTest(PersonController.class) // Inject all web related beans into this test env.
class PersonControllerTests {

  //@Autowired
  //PersonSerivce PersonSerivce; 咁樣會試左2個layer, 要揾野扮有personService
  //因為要試unit test 所以唔引入serivce 入內
  //想試一個controller
  @MockBean // 假的personService
  private PersonService personService;//obejct reference ->空指針

  @Autowired // @WebMvcTest -> new MockMvc() -> Spring context
  private MockMvc mockMvc;

  @Test
  void testPostUser(){
    Person person = new Person("Steven",3);
    Mockito.when(personService.createPerson(person)).thenReturn(person);

    //Convert an object to String value (JSON)
    String contenStr = new ObjectMapper().writeValueAsString(person);
    //Pretend Postman to make call
    
    mockMvc.perform(post("/api/v1/person"))
      .contentType(MediaType.APPLICATION_JSON)
      .content(contenStr)
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.name").value("Steven"))
      .andExpect(jsonPath("$.age").value(3))
      .andDo(print());
  }
  @Test
  void testGetUser() throws Exception{
    Person person = new Person("Sally",4);
    Mockito.when(personService.getPerson(1)).thenReturn(person);

    mockMvc.perform(get("/api/person/{idx}","1"))
      .contentType(MediaType.APPLICATION_JSON)
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.name").value("Sally"))
      .andExpect(jsonPath("$.age").value(4))
      .andDo(print());

  }

  @Test
  void testDeleteUser() throws Exception{
    Person person = new Person("Jenny",10);
    Mockito.when(personService.deletePerson(2)).thenReturn(person);

    mockMvc.perform(get("/api/person/{idx}","2"))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().string("true"))
      .andDo(print());
  }

  @Test
  void testPutUser() throws Exception{
    Person person = new Person("Tommy",5);
    Mockito.when(personService.updatPerson(3,person)).thenReturn(person);

    //Convert an object to String value (JSON)
    String contenStr = new ObjectMapper().writeValueAsString(person);
    //Pretend Postman to make call
    
    mockMvc.perform(put("/api/v1/person/{idx}","5"))
      .contentType(MediaType.APPLICATION_JSON)
      .content(contenStr)
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.name").value("Tommy"))
      .andExpect(jsonPath("$.age").value(20))
      .andDo(print());
  }

  @Test
  void testPatchUserAge() throws Exception{
    Person person = new Person("Thomas",2);
    Mockito.when(personService.patchPersonAge(5,2)).thenReturn(person);

    //Convert an object to String value (JSON)
    String contenStr = new ObjectMapper().writeValueAsString(person);
    //Pretend Postman to make call
    
    mockMvc.perform(put("/api/v1/person/{idx}/age/{age}","5","2"))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.name").value("Thomas"))
      .andExpect(jsonPath("$.age").value(2))
      .andDo(print());
  }

}
