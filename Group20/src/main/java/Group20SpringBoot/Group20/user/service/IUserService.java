package Group20SpringBoot.Group20.user.service;

import Group20SpringBoot.Group20.user.entity.UserModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserService {
    static abstract UserModel saveUser(@RequestBody UserModel userModel);

    List<UserModel> getAllUsers();
}
