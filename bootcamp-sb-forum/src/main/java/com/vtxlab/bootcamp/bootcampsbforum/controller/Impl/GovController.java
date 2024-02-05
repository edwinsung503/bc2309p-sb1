package com.vtxlab.bootcamp.bootcampsbforum.controller.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@RestController
@RequestMapping(value = "/gov/api/v2")
public class GovController implements GovOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Override
  public ResponseEntity<ApiResponse<UserPostDTO>> getUserPostDTO(int userId) {
    Optional<UserPostDTO> userPostDTO = userService.getUsers().stream() //
        .filter(e -> e.getId() == userId) //
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e, posts);
        }).findFirst();

    ApiResponse<UserPostDTO> apiResp;
    if (userPostDTO.isPresent()) {
      apiResp = ApiResponse.<UserPostDTO>builder() //
          .status(Syscode.OK)
          .data(userPostDTO.get()) //
          .build();
    } else {
      apiResp = ApiResponse.<UserPostDTO>builder() //
          .status(Syscode.NOTFOUND)
          .data(null) //
          .build();
    }
    return ResponseEntity.ok(apiResp);
    // return ResponseEntity.noContent().build(); // http status 204
  }



  //gov 指定要某一個user 的comment 拎哂出來
  @Override
  public UserPostDTO getUserCommentDTO(int userId) {
    return null;
  }

}
