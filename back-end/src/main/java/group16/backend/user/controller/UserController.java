package group16.backend.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group16.backend.user.entity.UserModel;
import group16.backend.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @PostMapping("/save")
    public UserModel signupUser(@RequestBody UserModel userModel) {
        return userService.signUpUser(userModel);
    }

}
