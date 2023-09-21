package com.aws.spring_study.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private  Integer userId;
    private  String username;
    private  String name;
    private  String phone;
}
