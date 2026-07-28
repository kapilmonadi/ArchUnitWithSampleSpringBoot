package com.kta.sample.controller;

import com.kta.sample.dto.UserRecord;
import com.kta.sample.entity.User;
import com.kta.sample.exception.UserNotFoundException;
import com.kta.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/user/{userIdStr}")
    public ResponseEntity<UserRecord> getUserRecord(@PathVariable Optional<String> userIdStr){

        log.info("Received a request with userId : {}", userIdStr);
        // hardcoded for now, replace with Service class invocation
        if(userIdStr.isPresent()){
            System.out.println("User id is " + userIdStr.get());
            UserRecord userRecord = userService.getUser(Long.parseLong(userIdStr.get()));
            return ResponseEntity.ok(userRecord);
        }
        else{
            throw new UserNotFoundException(String.format("User with Id %s not found", "null"));
        }
    }

    // Inappropriate implementation, controller should not refer to an entity class, should be caught by ArchUnit
    @GetMapping("/get/user/invalid")
    public ResponseEntity<User> getUserRecord(){
        User user = new User();
        user.setId(1L);
        user.setFirsName("Neo");
        user.setLastName("Oracle");
        return ResponseEntity.ok(user);
    }

    @GetMapping("/say-hello")
    public String sayHello(){
        return "Hello there !";
    }
}