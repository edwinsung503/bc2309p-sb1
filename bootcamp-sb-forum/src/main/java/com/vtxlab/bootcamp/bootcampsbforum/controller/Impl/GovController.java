package com.vtxlab.bootcamp.bootcampsbforum.controller.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserIdDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
//import com.vtxlab.bootcamp.bootcampsbforum.service.impl.ForumDatabaseHolder;


@RestController
@RequestMapping(value = "/gov/api/v2")
public class GovController implements GovOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private ForumDatabaseService forumDatabaseService;

  @Override
  public ApiResponse<List<UserPostDTO>> getUserPostDTOs() {

    List<User> users = userService.getUsers(); // call JPH -> DTO user list

    // clear DB
    forumDatabaseService.deleteAllUsers();

    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> userEntities =
        users.stream() //
            .map(e -> com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity.builder() //
              .jphId(e.getId())
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
    //forumDatabaseService.saveAllUsers(userEntities);

    // Convert User DTO ->
    List<UserPostDTO> userPostDTOs = users.stream() //
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e, posts);
        }).collect(Collectors.toList());

    return ApiResponse.<List<UserPostDTO>>builder() //
        .status(Syscode.OK) //
        .data(userPostDTOs) //
        .build();
  }

  public ApiResponse<UserPostDTO> getUserPostDTO(UserIdDTO userIdDTO) {

    
    UserPostDTO userPostDTO = userService.getUsers().stream() //
        //This gets a stream of users from the user service.
        .filter(e -> e.getId() == Integer.valueOf(userIdDTO.getUserId())) //
        //This filters the stream to only include the user matching the userId that was passed in.
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e , posts);
        //This transforms the filtered user into a UserPostDTO object. 
        //It does this by first retrieving a list of posts from the postService. 
        //Then, it uses the GovMapper.map method to transform the user and their associated posts into a UserPostDTO.
        //check 左個int 係咪係data 內的範圍
        }).findFirst()
        .orElseThrow( ()-> new RuntimeException()); // 揾唔到就throw 出去

    return ApiResponse.<UserPostDTO>builder() //
          .status(Syscode.OK)
          .data(userPostDTO) //
          .build();
    // return ResponseEntity.noContent().build(); // http status 204
  }

  //gov 指定要某一個user 的comment 拎哂出來
  @Override
  public UserPostDTO getUserCommentDTO(int userId) {
    return null;
  }

}
