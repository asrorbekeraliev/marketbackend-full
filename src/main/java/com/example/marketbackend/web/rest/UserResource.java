package com.example.marketbackend.web.rest;

import com.example.marketbackend.entity.User;
import com.example.marketbackend.security.SecurityUtils;
import com.example.marketbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/account")
    public ResponseEntity<?> getAccount(){
        String login = SecurityUtils.getCurrentUserName().get();
        User user = userService.findByUser(login);
        return ResponseEntity.ok(user);
    }
}
