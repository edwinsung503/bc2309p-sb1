package com.vtxlab.bootcamp.bootcampsbforum.config;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Component
public class AppStartRunner implements CommandLineRunner{
  
  @Autowired
  UserService userService;

  @Autowired
  PostService postService;

  @Autowired
  ForumDatabaseService forumDatabaseService;
 
  @Override
  public void run(String ... args){
    System.out.println("hello world -App Start Process.");

    // testing -> throw new RuntimeException();
    // 如果個server 唔ready 就throw -> server offline


    List<User> users = userService.getUsers(); // call JPH -> DTO user list

    // clear DB
    //forumDatabaseService.deleteAllUsers();

    List<UserEntity> userEntities = users.stream() //
            .map(e -> UserEntity.builder() //
              //.jphId(e.getId())
              .name(e.getName())
              .username(e.getUsername())
              .website(e.getWebsite())
              .addrLat(e.getAddress().getGeo().getLat())
              .addrLng(e.getAddress().getGeo().getLng())
              .email(e.getEmail())
              .phone(e.getPhone())
              .street(e.getAddress().getStreet())
              .city(e.getAddress().getCity())
              .suite(e.getAddress().getSuite())
              .zipcode(e.getAddress().getZipcode())
              .cName(e.getCompany().getName())
              .ccatchPhrase(e.getCompany().getCatchPhrase())
              .bs(e.getCompany().getBs())
              .build())
            .collect(Collectors.toList());

    System.out.println("userEntities=" + userEntities);
    
    // Save to DB
    forumDatabaseService.saveAllUsers(userEntities);
  }
   
}
