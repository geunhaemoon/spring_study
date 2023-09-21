package com.aws.spring_study.repository;

import com.aws.spring_study.dto.ModifyUserReqDto;
import com.aws.spring_study.dto.RegisterUserReqDto;
import com.aws.spring_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMappers {
    public int saveUser(RegisterUserReqDto registerUserReqDto);
    public List<User> getUserListAll();
    public int updateUser(ModifyUserReqDto modifyUserReqDto );
    public  int deleteUser(int userId);

}


