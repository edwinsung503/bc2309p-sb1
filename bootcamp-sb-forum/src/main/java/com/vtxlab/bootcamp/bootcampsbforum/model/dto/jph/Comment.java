package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Comment {

  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;

  
}
