package Group20SpringBoot.Group20.user.service;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

public interface IUserService {
    UserModel registerUser(UserModel usermodel);
    HashMap<String, String> loginUser(String email, String password);
    HashMap<String, String> resetPassword(String email, String newPass, String securityAnswer);
    boolean addUserToWorkspace(String email, WorkspaceModel workspace);
    List<WorkspaceModel> getWorkspaces(int userId);
    UserModel findUserById(int userId);
}
