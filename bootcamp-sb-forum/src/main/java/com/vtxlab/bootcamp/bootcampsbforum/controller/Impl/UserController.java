package com.vtxlab.bootcamp.bootcampsbforum.controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
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
  public ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByEmailOrPhone(
      String email, String phone) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> users =
        userService.getUsersByEmailOrPhoneOrderByEmailDesc(email, phone);
    return ApiResponse.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>>builder() //
        .status(Syscode.OK) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByLatLngGtrThan(
      String latitude, String longitude) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> users =
        userService.getUsersByLatLngGtrThan(latitude, longitude);
    return ApiResponse.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>>builder() //
        .status(Syscode.OK) //
        .data(users) //
        .build();
  }
  
  @Override
  public ApiResponse<UserEntity> saveUserAndPosts(@RequestBody UserPostRequestDTO dto){
    UserEntity userEntity = userService.save(dto);
    return ApiResponse.<UserEntity>builder() //
        .status(Syscode.OK) //
        .data(userEntity) //
        .build();
  }
}
