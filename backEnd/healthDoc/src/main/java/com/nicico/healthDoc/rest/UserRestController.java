package com.nicico.healthDoc.rest;


import com.nicico.healthDoc.dao.UserRepository;
import com.nicico.healthDoc.entity.User;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api/user")
class UserRestController {
    final private UserRepository userRepository;
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElse(new User());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
