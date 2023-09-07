package com.aws.spring_study.controller;

import com.aws.spring_study.dto.ParamsTestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetController {

    @GetMapping("/get/params/1")
    public Object paramsTest1( String name, Integer age){
        System.out.println(name);
        System.out.println(age);
        return null;
    }

    @GetMapping("/get/params/2")
    public Object paramsTest2(ParamsTestDto paramsTestDto){
        System.out.println(paramsTestDto);
        return null;
    }

    @GetMapping("/get/{id}")
    public Object pathVariable(@PathVariable("id") int id){
        System.out.println(id);
        return null;
    }


}


