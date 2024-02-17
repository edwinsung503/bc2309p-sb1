package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO {

  private int postId;
  private int id;
  private String body;
  
}
