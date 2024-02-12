package com.vtxlab.bootcamp.bootcampsbforum.resository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;

@Repository // -> Bean, similar to @Controller/@Service
public interface UserRespository extends JpaRepository<User, Long>  {
  
  //Spring Boot (Hibernate -> implementation class for JPA Interface)  
  //Hibernate usage : According to the driver (yml) , 
  //1. it can generate corresponding SQL synatx (implementation logic)
  //2. this class also implementing interface UserRespository -> bean
  //有個class implement 緊 UserRespository 
 // >JpaRepository<User, Long> help to generate 


}
