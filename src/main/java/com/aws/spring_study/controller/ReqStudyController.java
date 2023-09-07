package com.aws.spring_study.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReqStudyController {

    @GetMapping("/test/get") // 학습하기 위해서 get 붙인거지 REST 사용해서 할땐 get 안적어야함
    public Object get() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", "문근해");
        dataMap.put("email", "aaa@gmail.com");
        return dataMap;
    }

    @PostMapping("test/post")
    public Object post() {
        return "POST";
    }
    @PutMapping("test/put")
    public Object put(){
        return  "PUT";
    }

    @DeleteMapping("test/delete")
    public Object delete(){
        return  "DELETE";
    }
}

