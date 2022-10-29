package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j  //for log
public class GetController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //앞으로는 이것 대신에 아래의 @GetMapping을 쓸 것.
    public String hello(){
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        log.info("getVariable1으로 요청이 들어왔습니다.");
        return variable;
    }
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String str){
        log.info("getVariable2로 요청이 들어왔습니다. variable = {}",str);
        return str;
    }

    @ApiOperation(value="get 메소드 예제", notes = "@RequestParam 을 활용한 GET 메소드")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @ApiParam(value="이름",required = true) @RequestParam String name,
            @ApiParam(value="이메일",required = true)@RequestParam String email,
            @ApiParam(value="회사",required = true) @RequestParam String organization){
        return name + " " + email + " " + organization;
    }
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        param.entrySet().forEach((map)->{
            System.out.printf("key:%s value:%s\n",map.getKey(),map.getValue());
        });
        return "request2가 호출되었습니다.";
    }
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
