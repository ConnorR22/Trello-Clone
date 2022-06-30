package Group20SpringBoot.Group20.user.service;

import Group20SpringBoot.Group20.user.entity.UserModel;

import java.util.List;

public interface IUserService {
    UserModel saveUser(UserModel userModel);

    List<UserModel> getAllUsers();
}
