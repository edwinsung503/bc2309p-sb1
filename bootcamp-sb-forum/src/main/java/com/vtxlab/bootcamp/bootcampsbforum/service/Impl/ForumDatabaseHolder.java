package com.vtxlab.bootcamp.bootcampsbforum.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;
import com.vtxlab.bootcamp.bootcampsbforum.resository.UserRespository;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabase;

@Service
public class ForumDatabaseHolder implements ForumDatabase{

  @Autowired
  private UserRespository userRespository;
  
  @Override
  public List<User> saveAllUsers(List<User> users){
    return userRespository.saveAll(users);
  }


  
}
