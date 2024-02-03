package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommentDTO {
 
  private int id;
  private String username;
  private String email;
  private String phone;
  private List<CommentDTO> commentDTOs;
}
