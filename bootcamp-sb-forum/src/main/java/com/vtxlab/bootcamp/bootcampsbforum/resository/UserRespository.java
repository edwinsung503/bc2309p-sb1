package com.vtxlab.bootcamp.bootcampsbforum.resository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
  // Hibernate usage: According to the driver (yml),
  // 1. it can generate corresponding SQL syntax (implementation logic)
  // 2. this class also implementing interface UserRepository -> bean

  // Approach 1:
  // Query Methods: java method -> JPQL (Java Persistence Query Language)
  // Hibernate: select u from User u where u.email = ?
  List<User> findByEmail(String email);

  // Hibernate: select u from u.Users where u.email = ? and u.phone = ? order by u.email desc
  List<User> findByEmailAndPhoneOrderByEmailDesc(String email, String phone);

  // 1
  // Hibernate: select u from u.Users where u.email = ? or u.phone = ?
  List<User> findByEmailOrPhoneOrderByEmailDesc(String email, String phone);

  // Approach 2:
  // JPQL: hand-write JPQL
  // Method name is not important in JPQL
  @Query(value = "select u from User u where u.zipcode = :zc")
  List<User> findUsersByZipCode(@Param("zc") String zipcode);

  // 2
  @Query(
      value = "select u from User u where CAST(u.addrLat AS double) > :lat and CAST(u.addrLng AS double) > :lng")
  List<User> findUsersByLatitudeLongitudeGtrThan(@Param("lat") String latitude,
      @Param("lng") String longitude);

  // Approach 3 唔理想因為如果要改系統就要改paramter
  // Real SQL - Product Specific (PostgreSQL)
  @Query(value = "select e.* from users e where e.zipcode = :zc", nativeQuery = true)
  List<User> findUsersByZipCode2(@Param("zc") String zipcode);


}
