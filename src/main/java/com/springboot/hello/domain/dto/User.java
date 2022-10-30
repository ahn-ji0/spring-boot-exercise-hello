package com.springboot.hello.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String id;
    private String name;
    private String password;

    @Override
    public String toString(){
        return String.format("%s %s %s",this.id,this.name,this.password);
    }

}
