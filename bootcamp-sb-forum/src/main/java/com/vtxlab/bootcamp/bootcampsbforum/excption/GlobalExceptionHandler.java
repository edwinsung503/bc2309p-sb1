package com.vtxlab.bootcamp.bootcampsbforum.excption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;

//1. Create bean (@Contoller, @Service, @Configuration, etc) put into conetxt
//2. Autowired from Spring Context-> object - > use its instance method 

@RestControllerAdvice // bean when service start -> for return purpose -> web layer
public class GlobalExceptionHandler {
  //define error method

  @ExceptionHandler(RestClientException.class) //要同佢講捉D什麼先會捉
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) //http status code -> Bad request -> 400
  public ApiResponse<Void> restclientExceptionHanlder(){
    return ApiResponse.<Void>builder() //return 出去俾user
      .status(Syscode.REST_CLIENT_EXCEPTION)// 出左code 同message
      .data(null)
      .build();
  }
  //Exception 包埋runtime exception
  @ExceptionHandler(NullPointerException.class) //要同佢講捉D什麼先會捉
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> npeclientExceptionHanlder(){
    return ApiResponse.<Void>builder() //return 出去俾user
      .status(Syscode.NULL_POINTER_EXCEPTION)// 出左code 同message
      .data(null)
      .build();
  }

  //Exception 包埋runtime exception
  @ExceptionHandler(Exception.class) //要同佢講捉D什麼先會捉
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResponse<Void> ExceptionHanlder(){
    return ApiResponse.<Void>builder() //return 出去俾user
      .status(Syscode.GENERAL_EXCEPTION)// 出左code 同message
      .data(null)
      .build();
  }
  
}
