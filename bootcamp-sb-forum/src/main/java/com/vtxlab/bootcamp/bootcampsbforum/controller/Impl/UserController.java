package com.vtxlab.bootcamp.bootcampsbforum.controller.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/api/v2")
public class UserController implements UserOperation {
  
  @Autowired
  private UserService userService;

  @Override
  public List<User> getUsers(){
    return userService.getUsers();
  }

  //@Override
  //public User getUser(int userId ){
  //  return userService.getUsers().stream()
  //  .filter(e -> e.getId() == userId)
  //  .findFirst()
  //  .orElse(null);
  //}
  @Override
  public ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByEmailOrPhone(
      String email, String phone) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users =
        userService.getUsersByEmailOrPhoneOrderByEmailDesc(email, phone);
    return ApiResponse.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder() //
        .status(Syscode.OK) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByLatLngGtrThan(
      String latitude, String longitude) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users =
        userService.getUsersByLatLngGtrThan(latitude, longitude);
    return ApiResponse.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder() //
        .status(Syscode.OK) //
        .data(users) //
        .build();
  }
}
