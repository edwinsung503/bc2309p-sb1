package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Post {

  private int userId;
  private int id;
  private String title;
  private String body;

}
