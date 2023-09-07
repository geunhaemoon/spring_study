package com.aws.spring_study.controller;


import com.aws.spring_study.dto.JsonTestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

// 호출 컨트롤러
@RestController
public class RespStudyController {

    @GetMapping("/resp/str")
    public String strTest(){
        return "문자열";
    }

    @GetMapping("/resp/obj")
    public Object objectTest() {
        Map<String, Object> responseMap = new HashMap<>();
        return responseMap; // Json으로 응답
    }

    @GetMapping("/resp/obj2")
    public Object objectTest2() {
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("문근해");
        jsonTestDto.setAge(25);
        return jsonTestDto; // Json으로 응답
    }

    @GetMapping("/resp/status")
    public Object statusTest(HttpServletResponse response) {
        response.setStatus(400);
        return null;
    }

    //위에꺼 status 대신 이거 씀 위에꺼 별로임
    //여기로 요청 들어오면 객체만들어서 응답함
    @GetMapping("/resp/resp-entity")
            //여기 원래 오브젝트 넣는데
    public ResponseEntity<?> responseEntityTest(){
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("문근해");
        jsonTestDto.setAge(25);
        return new ResponseEntity<>(jsonTestDto, HttpStatus.UNAUTHORIZED);
                    // 공통
        //응답할 타임이 JsonTestDto, 응답되어진 타입으로 반환함..
    }

    @GetMapping("/resp/map-resp-entity")
    public ResponseEntity<Map<String, Object>> mapResponseEntity(){
        Map<String, Object> map = new HashMap<>();
        map.put("data", "데이터입니다");
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

    //직관적임 , 최종적인 응답 코드
    @GetMapping("/resp")
    public ResponseEntity<JsonTestDto> jsonResponse(){
        JsonTestDto jsonTestDto = new JsonTestDto();
        jsonTestDto.setName("문근해");
        jsonTestDto.setAge(25);
                                // 200으로 body에 응답,
        return  ResponseEntity.ok().body(jsonTestDto);
                                    // ok 말고 status 써서 다른거 써서 사용해도 됨
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonTestDto);
//        return ResponseEntity.status(405).body(jsonTestDto);
//        return ResponseEntity.badRequest().body(jsonTestDto);

    }

}
