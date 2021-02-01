package com.nicico.healthDoc.rest;


import com.nicico.healthDoc.dao.UserRepository;
import com.nicico.healthDoc.entity.User;
import com.nicico.healthDoc.response.BaseResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
class UserRestController {
    final private UserRepository userRepository;
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable long id){
//        Optional<User> byId = userRepository.findById(id);
//        User user = byId.orElse(new User());
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName){
        Optional<User> byId = userRepository.findByUserName(userName);
        User user = byId.orElse(new User());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/{userName}")
    public ResponseEntity<BaseResponse> createUser(
            @PathVariable String userName,
            @RequestBody User user
    ){
        try {
            userRepository.saveAndFlush(user);
            return new ResponseEntity<>(new BaseResponse().setStatus(200).setMessage("عملیات با موفقیت انجام شد") ,HttpStatus.OK);
        }
        catch (Exception e){
            BaseResponse response = new BaseResponse();
            response.setMessage("");
            return new ResponseEntity<>(new BaseResponse().setStatus(401).setMessage("نام کاربری تکراری است") ,HttpStatus.OK);
        }
    }
}
