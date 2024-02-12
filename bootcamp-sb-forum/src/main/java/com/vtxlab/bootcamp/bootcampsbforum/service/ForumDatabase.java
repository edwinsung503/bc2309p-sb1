package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

public interface ForumDatabase {
  
  List<User> saveAllUsers(List<User> users);
}
