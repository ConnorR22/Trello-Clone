package Group20SpringBoot.Group20.user.controller;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import Group20SpringBoot.Group20.user.service.IUserService;
import Group20SpringBoot.Group20.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository UserRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "Home";
    }

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }

    @PostMapping("/register")
    public String registerUser() {
        IUserService.saveUser(new UserModel());


        return "Register";
    }
    @GetMapping("/getAll")
    public List<UserModel> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/login")
    public UserModel getUser(int id){
        return userService.getUser(id);
    }

}

