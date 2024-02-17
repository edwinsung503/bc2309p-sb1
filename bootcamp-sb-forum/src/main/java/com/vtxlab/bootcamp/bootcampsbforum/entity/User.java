package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // table 對應的Object , Class mapped to the db table
@Table(name = "Users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generated
  private Long id;
  private int jphId;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  @Column(name = "ADDR_LATE")
  private String addrLat;
  @Column(name = "ADDR_LNG")
  private String addrLng;
  @Column(name = "COMP_NAME")
  private String cName;
  @Column(name = "COMP_CATCH_PRHASE")
  private String ccatchPhrase;
  @Column(name = "COMP_BUSINESS_SERVICE")
  private String bs;


}
