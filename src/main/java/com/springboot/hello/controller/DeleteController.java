package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    @DeleteMapping(value = "/{variable}")
    public String deleteExample(@PathVariable("variable") String str){
        return str;
    }

    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "email : " + email;
    }

}
