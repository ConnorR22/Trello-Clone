package Group20SpringBoot.Group20.user.controller;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }


//    @PutMapping("/assignTask/{userId}")
//    public UserModel updateTask(@PathVariable Long userId, @RequestParam Long taskId)
//    {
//        UserModel model = userService.updateTask(userId, taskId);
//        return model;
//    }
//
    @GetMapping("/getAll")
    public List<UserModel> getAllUsers()
    {
        return userService.getAllUsers();
    }


}
