package com.vtxlab.bootcamp.demothymeleafproject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.demothymeleafproject.dto.CoinData;
import com.vtxlab.bootcamp.demothymeleafproject.service.ApiService;

@RestController
public class CoinController {
  
  @Autowired
  private ApiService apiService;
  //http://localhost:8080/coin-data
  @GetMapping("/coin-data")
  public String displayExternalData(Model model){
    List<CoinData> coinDataList = apiService.fetchCoinData();
    model.addAttribute("coinDataList", coinDataList);
    return "coin-data"; 
  }
  
}
