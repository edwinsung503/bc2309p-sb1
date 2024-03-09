package com.vtxlab.bootcamp.demothymeleafproject.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.demothymeleafproject.dto.CoinData;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

  
    public List<CoinData> fetchCoinData(){
      String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-ZmN8v5NihmGLP3oayyFAPbsS";
      CoinData [] response = restTemplate.getForObject(apiUrl, CoinData[].class);
      return Arrays.asList(response);
    }
}
