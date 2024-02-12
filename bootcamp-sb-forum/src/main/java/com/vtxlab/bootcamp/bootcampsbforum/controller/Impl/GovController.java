package com.vtxlab.bootcamp.bootcampsbforum.controller.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Comment;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabase;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/gov/api/v2")
public class GovController implements GovOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  @Autowired
  private ForumDatabase forumDatabase;

  @Override
  //controller 係用來轉換
  public ApiResponse<UserPostDTO> getUserPostDTOs() {
    List<User> users = userService.getUsers(); // call JPH -> DTO user list
    
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> userEntity = users.stream()
      .map(e -> {
        return com.vtxlab.bootcamp.bootcampsbforum.entity.User.builder()
          .name(e.getName())
          .username(e.getUsersName())
          .website(e.getWebsite())
          .addLat(e.getAddress().getGeo().getLat())
          .addrLng(e.getAddress().getGeo().getLng())
          .email(e.getEmail())
          .phone(e.getPhone())
          .street(e.getAddress().getStreet())
          .city(e.getAddress().getCity())
          .suite(e.getAddress().getSuite())
          .zipcode(e.getAddress().getZipcode())
          .cName(e.getCompay().getName())
          .catchPhrase(e.getCompay().getCatchPhrase())
          .cBusinessService(e.getCompay().getCBusinessService());
      } ) // convert user -> user entity
      .collect();
    //save to DB
    forumDatabase.saveAllUsers(userEntity);

    //Convert User DTO -> 
    List<UserPostDTO> userPostDTO = userService.getUsers().stream() //
        //This gets a stream of users from the user service.
        .filter(e -> e.getId() == userId) //
        //This filters the stream to only include the user matching the userId that was passed in.
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e , posts);
        //This transforms the filtered user into a UserPostDTO object. 
        //It does this by first retrieving a list of posts from the postService. 
        //Then, it uses the GovMapper.map method to transform the user and their associated posts into a UserPostDTO.
        }).findFirst()
        .orElseThrow( ()-> new RuntimeException()); // 揾唔到就throw 出去

    return ApiResponse.<UserPostDTO>builder() //
          .status(Syscode.OK)
          .data(userPostDTO) //
          .build();
  }

  public ApiResponse<UserPostDTO> getUserPostDTO(int userId) {

    
    UserPostDTO userPostDTO = userService.getUsers().stream() //
        //This gets a stream of users from the user service.
        .filter(e -> e.getId() == userId) //
        //This filters the stream to only include the user matching the userId that was passed in.
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e , posts);
        //This transforms the filtered user into a UserPostDTO object. 
        //It does this by first retrieving a list of posts from the postService. 
        //Then, it uses the GovMapper.map method to transform the user and their associated posts into a UserPostDTO.
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
