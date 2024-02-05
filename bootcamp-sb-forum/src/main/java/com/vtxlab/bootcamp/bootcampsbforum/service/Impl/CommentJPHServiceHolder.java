package com.vtxlab.bootcamp.bootcampsbforum.service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.stream.events.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;

@Service
public class CommentJPHServiceHolder implements CommentService {
  
  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.users}")
  private String commentsUri;

  @Override
  public List<Comment> getComments(){

    RestTemplate restTemplate = new RestTemplate();
      String url = BcUtil.getUrl(Scheme.HTTPS, domain, commentsUri);

      Comment[] comments = restTemplate.getForObject(url, Comment[].class);

      return Arrays.stream(comments)
        .collect(Collectors.toList());
  }

}
