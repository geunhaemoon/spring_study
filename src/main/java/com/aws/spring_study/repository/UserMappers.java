package com.aws.spring_study.repository;


import com.aws.spring_study.dto.RegisterUserReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMappers {

    public int saveUser(RegisterUserReqDto registerUserReqDto);

}
