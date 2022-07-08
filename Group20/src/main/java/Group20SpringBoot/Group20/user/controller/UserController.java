package Group20SpringBoot.Group20.user.controller;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import Group20SpringBoot.Group20.user.service.IUserService;
import Group20SpringBoot.Group20.user.service.UserService;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository UserRepo;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean saveUser(@RequestBody UserModel userModel) {
        return userService.registerUser(userModel);
    }

    @PostMapping("/login/{email}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String loginUser(@PathVariable String email, @RequestBody String password){
        return userService.loginUser(email, password);
    }

    @PostMapping("/resetPassword/{email}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String resetPassword(@PathVariable String email, @RequestParam String securityAnswer){
        return userService.resetPassword(email, securityAnswer);
    }

    @PutMapping("/changePassword/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean changePassword(@PathVariable int userId, @RequestParam String newPass){
        return userService.changePassword(userId, newPass);
    }




    //sanjay
    @PutMapping("/add_workspace/{email}")
    public boolean addUserToWorkspace(@PathVariable String email, @RequestBody WorkspaceModel workspace){
        return userService.addUserToWorkspace(email, workspace);
//        System.out.println("User Added to the Workspace Successfully");
    }
    @PutMapping ("/delete_workspace/{userId}")
    public void deleteWorkspaceFromUser(@PathVariable int userId, @RequestBody WorkspaceModel workspace){
        userService.deleteWorkspaceFromUser(userId, workspace);
        System.out.println("User Deleted from the Workspace Successfully");

    }


}

