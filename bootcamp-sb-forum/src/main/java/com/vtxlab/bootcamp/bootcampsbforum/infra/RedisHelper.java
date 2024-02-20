package com.vtxlab.bootcamp.bootcampsbforum.infra;

import java.util.Objects;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisHelper {// Holder 
  
  private RedisTemplate<String, String> redisTemplate;

  private ObjectMapper objectMapper; //NPE

  public RedisHelper(RedisConnectionFactory factory,ObjectMapper objectMapper,
        RedisTemplate<String, String> redisTemplate){
    
      Objects.requireNonNull(factory);
      Objects.requireNonNull(objectMapper);
      Objects.requireNonNull(redisTemplate);
      this.redisTemplate = redisTemplate;
      this.objectMapper = objectMapper;
      //封裝左heap 內的objectMapper 同redisTemplate -> 唔人掂到
    }
  
  public RedisHelper(RedisConnectionFactory factory,ObjectMapper objectMapper){
  //public RedisHelper(RedisTemplate<String,String> redisTemplate){
    //Objects.requireNonNull(redisTemplate);// 唔俾人放null;
    //help me to no need to write again in every program -> encapuslation
    Objects.requireNonNull(factory);
    Objects.requireNonNull(objectMapper);
    RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
    //封裝左heap 內的objectMapper 同redisTemplate -> 唔人掂到
  }

  // new RedisHelper().set("vincent", user)
  public void set(String key, Object value) throws JsonProcessingException{
    ObjectMapper objectMapper = new ObjectMapper(); // for user -> change to this
    String serilized = objectMapper.writeValueAsString(value); // writeValueAsString 食Object
    redisTemplate.opsForValue().set(key, serilized); // <String, String>
  }
    //<T> - > Object value
   //User2 user =  new RedisHelper().get("vincent", User2.class)
  public <T> T get(String key, Class<T> clazz) throws JsonProcessingException{
    String serialized = redisTemplate.opsForValue().get(key); //<String, String>
    return objectMapper.readValue(serialized, clazz);

  }

}
