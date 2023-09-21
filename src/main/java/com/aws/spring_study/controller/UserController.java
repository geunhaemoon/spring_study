package com.aws.spring_study.controller;

import com.aws.spring_study.dto.ModifyUserReqDto;
import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import com.aws.spring_study.repository.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMappers userMappers;

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<Integer> registerUSer(@RequestBody RegisterUserReqDto registerUserReqDto) {

        Integer count = userMappers.saveUser(registerUserReqDto);

        return ResponseEntity.ok().body(count);
    }


    @CrossOrigin // 이거 있어야 보낼수있음
    @GetMapping("/user/list")
                        //항상 맞춰주기
    public ResponseEntity<List<User>> userListAll(){
        return ResponseEntity.ok().body(userMappers.getUserListAll());
    }

                        //오토로 붙은 번호
    @PutMapping("/users/{userId}")
    @CrossOrigin
    public ResponseEntity<Integer> modifyUser(
            @PathVariable int userId,
            @RequestBody ModifyUserReqDto modifyUserReqDto){
        System.out.println(userId);
        System.out.println(modifyUserReqDto);
        return ResponseEntity.ok().body(userMappers.updateUser(modifyUserReqDto));
    }

    @CrossOrigin
    @DeleteMapping("/users/{userId}")
    public  ResponseEntity<Integer> deleteUser(@PathVariable int userId){
        return  ResponseEntity.ok().body(userMappers.deleteUser(userId));
    }

}
