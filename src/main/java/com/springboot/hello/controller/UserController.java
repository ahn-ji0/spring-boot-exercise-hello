package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import com.springboot.hello.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto){
        User user = new User(userRequestDto.getId(),userRequestDto.getName(),userRequestDto.getPassword());
        return ResponseEntity.ok().body(userDao.add(user));
    }

    @DeleteMapping(value = "/user/all")
    public ResponseEntity<Integer> deleteAll(){
        return ResponseEntity.ok().body(userDao.deleteAll());
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Integer> deleteId(@PathVariable String id){
        return ResponseEntity.ok().body(userDao.deleteId(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(this.userDao.getAll());
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getId(@PathVariable String id){
        return ResponseEntity.ok().body(this.userDao.getId(id));
    }

}
