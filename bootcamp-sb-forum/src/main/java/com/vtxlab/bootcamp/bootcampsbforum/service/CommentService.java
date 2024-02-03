package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import javax.xml.stream.events.Comment;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;


public interface CommentService {
  
  List<Comment> getComments();  
}
