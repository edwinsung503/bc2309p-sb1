package com.vtxlab.bootcamp.demothymeleafproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoinData {

  private String id;
  private String image;
  private Double currentPrice;
  
}
