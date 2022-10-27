package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @RequestMapping(value="/domain",method = RequestMethod.PUT)
    public String putExample(){
        return "Hello Put API";
    }

    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map-> {sb.append(map.getKey()+":"+map.getValue()+"\n");
        });
        return sb.toString();
    }
    @PutMapping(value = "/member2")
    public String putMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
    @PutMapping(value = "/member2")
    public ResponseEntity<MemberDto> putMemberDto2(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
