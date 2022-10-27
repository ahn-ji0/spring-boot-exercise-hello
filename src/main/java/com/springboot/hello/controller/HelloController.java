package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {
    @GetMapping(value = "/hello")
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
}
