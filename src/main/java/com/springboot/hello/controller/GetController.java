package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //앞으로는 이것 대신에 아래의 @GetMapping을 쓸 것.
    public String hello(){
        return "Hello World";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String str){
        return str;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String name,@RequestParam String email,@RequestParam String organization){
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
