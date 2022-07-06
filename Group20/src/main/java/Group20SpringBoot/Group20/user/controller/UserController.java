package Group20SpringBoot.Group20.user.controller;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import Group20SpringBoot.Group20.user.service.IUserService;
import Group20SpringBoot.Group20.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository UserRepo;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return userService.registerUser(userModel);
    }

    @GetMapping("/login/{email}")
    @CrossOrigin(origins = "http://localhost:3000")
    public HashMap<String, String> loginUser(@PathVariable String email, @RequestParam String password){
        return userService.loginUser(email, password);
    }

    @PutMapping("/resetPassword/{email}")
    @CrossOrigin(origins = "http://localhost:3000")
    public HashMap<String, String> resetPassword(@PathVariable String email, @RequestParam String newPass, @RequestParam String securityAnswer){
        return userService.resetPassword(email, newPass, securityAnswer);
    }

}

