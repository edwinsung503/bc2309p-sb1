package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

//if need instance varaible -> change to instance method -> @Component -> Bean -> Spring Context
@Component
public class GovMapper {
  //save 1 次可以拎到3個結構 user 同好多唔同的post
  public static UserEntity map(UserPostRequestDTO dto) {
    UserEntity userEntity = UserEntity.builder()
          .name(dto.getName()) //
          .username(dto.getUsername()) //
          .email(dto.getEmail()) //
          .phone(dto.getPhone()) //
          .website(dto.getWebsite()) //
          .street(dto.getStreet()) //
          .suite(dto.getSuite()) //
          .city(dto.getCity()) //
          .zipcode(dto.getZipcode()) //
          .addrLat(dto.getAddrLat()) //
          .addrLng(dto.getAddrLong()) //
          .cName(dto.getCompanyName()) //
          .ccatchPhrase(dto.getCompanyCatchPhrase()) //
          .bs(dto.getCompanyBusService()) //
          .build();

        List<PostEntity> postEntities = dto.getPosts().stream() //
        .map(e -> {
          PostEntity postEntity = PostEntity.builder() //
              .title(e.getTitle()) //
              .body(e.getBody()) //
              .build();
          postEntity.setUser(userEntity); // ManyToOne relationship -> FK
          return postEntity;
        }).collect(Collectors.toList());


        userEntity.setPosts(postEntities);
        return userEntity;

  }


  //map 返自身object 
  public static UserPostDTO map(User user, List<Post> posts) {
    //入個userID 
    //This Java code snippet is using the Stream API 
    //to perform operations on a list of `Post` objects named `posts`. 
    List<PostDTO> postDTOs = posts.stream() //
        //converts the `posts` list into a Stream.
        .filter(p -> p.getUserId() == user.getId()) //
        //filters the stream to only include `Post` objects (List<Post> posts)
        //where the `userId` matches the `id` of a `User` object named `user`.
        .map(p -> {
          return PostDTO.builder() //
              .id(p.getId()) //
              .title(p.getTitle()) //
              .build(); //
        //transforms each `Post` in the stream into a `PostDTO` object 
        //using the Builder pattern.
        //The `PostDTO` object includes the `id` and `title` from the `Post` object.
        }).collect(Collectors.toList());
      //4. `.collect(Collectors.toList())`: converts the stream back into a List.

      //The result is a list of `PostDTO` objects (`postDTOs`), 
      //each representing a `Post` with the same `userId` as `user`.

    return UserPostDTO.builder() //
        .id(user.getId()) // sets the user's ID.
        //.username(user.getName())//sets the user's name.
        //.email(user.getEmail()) //sets the user's email.
        .username(user.getUsername()).email(user.getEmail()) //
        .phone(user.getPhone()) //sets the user's phone number.
        .postDTOs(postDTOs) //sets the list of `PostDTO` objects associated with the user.
        .build();

    //The `return UserPostDTO.builder()...build();` line 
    //is creating a new instance of the `UserPostDTO` class using the builder pattern.

    //The builder pattern is a design pattern that allows 
    //for the step-by-step creation of complex objects using the correct sequence of actions. 
    //The construction is controlled by a director object that only needs to know the type of object it is to create.

    //In this case, each line inside the builder is setting a property of the `UserPostDTO` object:

    //Finally, `.build()` is called to return the created `UserPostDTO` object. 
    //This method is always the last method called in the builder pattern. 
    //It returns the constructed object after all the properties have been set.
  }
  //gov 指定要某一個user 的comment 拎哂出來

  
  //public static UserCommentDTO map1(User user, List<Comment> comments) {
  //  List<CommentDTO> commentDTOs = comments.stream() //
  //      .filter(p -> p.getId() == user.getId() ) //
  //     .map(p -> {
  //        return CommentDTO.builder()
  //         .body(p.getBody())
  //        .build();
  //      }).collect(Collectors.toList());

  //  return UserCommentDTO.builder() //
  //    .id(user.getId()) //
  //   .username(user.getName())
  //    .email(user.getEmail()) //
  //    .phone(user.getPhone()) //
  //    .commentDTOs(commentDTOs) //
  //    .build();
  //}

}

//User (userId) -> Post(postId) -> Comment(commentId)