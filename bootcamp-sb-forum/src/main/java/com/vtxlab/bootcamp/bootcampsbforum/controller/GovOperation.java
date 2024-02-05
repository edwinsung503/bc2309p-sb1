package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;

public interface GovOperation {
  //http://localhost:8080/gov/api/v2/user?id=1
  @GetMapping(value = "/user") // request param
  ResponseEntity<ApiResponse<UserPostDTO>> getUserPostDTO(@RequestParam(value = "id") int userId);

  // The ResponseEntity<ApiResponse<UserPostDTO>> return type 
  //indicates that the method 
  //will return an instance of ApiResponse wrapped in a ResponseEntity. 
  //The ApiResponse is expected to contain a UserPostDTO object.

  @GetMapping(value= "/comments")
  UserPostDTO getUserCommentDTO(@RequestParam(value = "id") int userId);

   
}
