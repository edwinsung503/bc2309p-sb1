package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {
  
  private int id ; //Post ID
  private String title;
  
}
