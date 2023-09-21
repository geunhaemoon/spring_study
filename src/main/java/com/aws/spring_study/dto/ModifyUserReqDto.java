package com.aws.spring_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyUserReqDto {
    private int userId;
    private String username;
    private String name;
    private String phone;
}
