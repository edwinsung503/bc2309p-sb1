package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;

public interface GovOperation {

  @GetMapping(value= "/user")
  ResponseEntity<ApiResponse<UserPostDTO>> getUserPostDTO (@RequestParam (value = "id") int index);

  @GetMapping(value= "/comments")
  UserPostDTO getUserCOmmenDto (@RequestParam (value = "id") int index);


  // The ResponseEntity<ApiResponse<UserPostDTO>> return type indicates that the method 
  //will return an instance of ApiResponse wrapped in a ResponseEntity. 
  //The ApiResponse is expected to contain a UserPostDTO object.
   
}
