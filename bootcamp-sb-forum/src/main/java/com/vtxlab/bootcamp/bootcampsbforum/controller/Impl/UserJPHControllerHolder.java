package com.vtxlab.bootcamp.bootcampsbforum.controller.Impl;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserController;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;

public class UserJPHControllerHolder implements UserController {
  
  @Override
  List<User> getUsers();
}
