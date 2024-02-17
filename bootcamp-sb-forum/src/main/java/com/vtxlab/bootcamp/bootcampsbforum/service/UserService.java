package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {

  List<User> getUsers(); 
  
  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getUsersByEmailOrPhoneOrderByEmailDesc(
      String email, String phone);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getUsersByLatLngGtrThan(
      String latitude, String longitude);
}
