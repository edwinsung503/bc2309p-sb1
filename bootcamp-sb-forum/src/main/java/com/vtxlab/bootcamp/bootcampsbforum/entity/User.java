package com.vtxlab.bootcamp.bootcampsbforum.entity;

import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity // table 對應的Object , Class mapped to the db table
@Table (name = "USERS")
@Getter
@AllArgsConstructor
@Builder
public class User {
  
  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int jphid ;
  private String name;
  private String email;
  private String phone ;
  private String website;
  private String street ;
  private String suite;
  private String city;
  private String zipcode;
  @Column(name = "ADD_LA")
  private String addLat;
  @Column(name = "ADD_LNG")
  private String addrLng ;
  @Column(name = "COMP_NAME")
  private String cName;
  @Column(name = "COMP_CATCH_PHRASE")
  private String catchPhrase;
  @Column(name = "COMP_BUSINESS_SERVICE")
  private String cBusinessService;


}
