package group16.backend.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group16.backend.user.entity.UserModel;
import group16.backend.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @CrossOrigin(origins = {"http://localhost:3000"})
    @PostMapping("/save")
    public UserModel signupUser(@RequestBody UserModel userModel) throws Exception {
        return userService.signUpUser(userModel);
    }

    @PostMapping("/login")
    public UserModel loginUser(@RequestBody UserModel userModel) throws Exception {
        return userService.logInUser(userModel.getEmail(), userModel.getPassword());
    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @PutMapping("/assignTask/{userId}")
    public UserModel updateTask(@PathVariable Long userId, @RequestParam Long taskId) {

        return userService.updateTask(userId, taskId);

    }

    @CrossOrigin(origins = {"http://localhost:3000"})
    @GetMapping("/getAll")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }
}
