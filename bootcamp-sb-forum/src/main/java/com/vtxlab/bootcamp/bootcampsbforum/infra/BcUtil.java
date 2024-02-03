package com.vtxlab.bootcamp.bootcampsbforum.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class BcUtil {
  
  public static String getUrl(Scheme scheme,String donamin, String uri){
    return UriComponentsBuilder.newInstance()
      .scheme(scheme.toLowerCase())
      .host(donamin)
      .path(uri)
      .toUriString(); // handle special character , \://
  }
}
