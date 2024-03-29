package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.annotation.UserIdCheck;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserIdDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;

//SOAP API -> XML -> SPRING
//REST / RESTFUL ->JSON -> SPRING 

@Validated // 1
public interface GovOperation {
  //http://localhost:8080/gov/api/v2/user?id=1
  @GetMapping(value = "/user") // request param
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<UserPostDTO> getUserPostDTO(
      @UserIdCheck @RequestParam(value = "id") UserIdDTO userIdDTO); //2 用object 去接住

  // The ResponseEntity<ApiResponse<UserPostDTO>> return type 
  //indicates that the method 
  //will return an instance of ApiResponse wrapped in a ResponseEntity. 
  //The ApiResponse is expected to contain a UserPostDTO object.

  //http://localhost:8080/gov/api/v2/comments?id=1
  @GetMapping(value= "/comments")
  UserPostDTO getUserCommentDTO(@RequestParam(value = "id") int userId);

  //get all users
  //http://localhost:8080/gov/api/v2/users
  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK) //200
  ApiResponse<List<UserPostDTO>> getUserPostDTOs();

}
