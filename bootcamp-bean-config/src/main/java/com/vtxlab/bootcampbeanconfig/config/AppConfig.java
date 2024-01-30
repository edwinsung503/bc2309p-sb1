package com.vtxlab.bootcampbeanconfig.config;
//bean -> inject 入去似new object 但係server start 就ready at spring context

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration// one of the @Component -> appconfig 自新係個bean入面 
//step 1.5 變成object 放入垃圾筒
public class AppConfig {
  
  @Bean(name = "superm")
  String superman() {
    return  "Superman!!!"; // create a String object 放入垃圾筒 as a Bean
  }
  @Bean(name = "supern")
  String superwomen(){
    return "Superwomen!!!";
  }

}
