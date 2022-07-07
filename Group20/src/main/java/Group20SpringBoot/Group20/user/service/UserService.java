package Group20SpringBoot.Group20.user.service;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.service.IWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel registerUser(UserModel usermodel) {

        Optional<UserModel> optionalUserModel = userRepository.findByEmailId(usermodel.getEmailId());
        if (optionalUserModel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exists With that Email.");
        }

        return userRepository.save(usermodel);
    }

    @Override
    public HashMap<String, String> loginUser(String email, String password) {
        HashMap<String, String> request = new HashMap<>();

        UserModel user = null;
        Optional<UserModel> optionalUserModel = userRepository.findByEmailId(email);
        if (optionalUserModel.isPresent()) {
            user = optionalUserModel.get();
            if (user.getPassword().equals(password)) {
                request.put("result", "" + user.getUserId());
                request.put("status", "success");
            } else {
                request.put("result", "Login unsuccessful");
                request.put("status", "Invalid Email or Password");
            }
        }
        // User with sent in email string does not exist in database
        else {
            request.put("result", "Login unsuccessful");
            request.put("status", "No user registered with that email.");
        }
        return request;
    }

    @Override
    public HashMap<String, String> resetPassword(String email, String newPass, String securityAnswer) {
        HashMap<String, String> request = new HashMap<>();

        UserModel user = null;
        Optional<UserModel> optionalUserModel = userRepository.findByEmailId(email);

        if (optionalUserModel.isPresent()) {
            user = optionalUserModel.get();

            // If security answer matches, register the new password
            if (user.getSecretKey().equals(securityAnswer)) {
                user.setPassword(newPass);
                userRepository.save(user);

                request.put("result", "" + user.getUserId());
                request.put("status", "success");
            } else {
                request.put("result", "Reset unsuccessful");
                request.put("status", "Invalid Security Answer");
            }
        }
        // User with sent in email string does not exist in database
        else {
            request.put("result", "Reset unsuccessful");
            request.put("status", "No user registered with that email.");
        }
        return request;
    }

//    @Override
//    public boolean addUserToWorkspace(String email, WorkspaceModel workspace) {
//        UserModel user = null;
//        Optional<UserModel> optionalUserModel = userRepository.findByEmailId(email);
//
//        if (optionalUserModel.isPresent()) {
//            user = optionalUserModel.get();
//
//            List<WorkspaceModel> workspaces = user.getWorkspaces();
//            if (workspaces == null) {
//                workspaces = new ArrayList<>();
//            }
//
//            if (workspaces.contains(workspace)) {
//                workspaces.add(workspace);
//                user.setWorkspaces(workspaces);
//                userRepository.save(user);
//
//                return true;
//            }
//        }
//
//        return false;
//    }

    @Override
    public List<WorkspaceModel> getWorkspaces(int userId) {
        UserModel user = findUserById(userId);
        return user.getWorkspaces();
    }

    @Override
    public UserModel findUserById(int userId) {
        UserModel user = null;
        Optional<UserModel> optionalUserModel = userRepository.findById(userId);

        if (optionalUserModel.isPresent()) {
            user = optionalUserModel.get();
        }
        return user;
    }

    //sanjay
    @Autowired
    IWorkspaceService workspaceService;


public List<WorkspaceModel> getUserWorkspaces(int userId) {

    Optional<UserModel> user = null;
    List<WorkspaceModel> workspacemodel = null;
    user = userRepository.findById(userId);
    if (user.isPresent()) {

        workspacemodel = user.get().getWorkspaces();

    }

        return workspacemodel;

}


    @Override
    public void addWorkspaceToUser(int userId, int workspaceId) {

        Optional<UserModel> user = null;

        try {
            user = userRepository.findById(userId);
            if (user.isPresent()) {

                UserModel usermodel = user.get();
                WorkspaceModel workspacemodel = workspaceService.findWorkspaceByID(workspaceId);

                List<WorkspaceModel> workspace_list = usermodel.getWorkspaces();

                if (workspace_list == null) {
                    workspace_list = new ArrayList<>();
                }

                workspace_list.add(workspacemodel);
                usermodel.setWorkspaces(workspace_list);
                userRepository.save(usermodel);

            }

        } catch (Exception err) {
            System.out.println("Cannot add workspace to user");

        }

    }

    @Override
    public void deleteWorkspaceFromUser(int userId, int workspaceId) {

            Optional<UserModel> user = null;
            try {
                user = userRepository.findById(userId);
                if (user.isPresent()) {

                    UserModel usermodel = user.get();
                    WorkspaceModel workspacemodel = workspaceService.findWorkspaceByID(workspaceId);

                    List<WorkspaceModel> workspace_list = usermodel.getWorkspaces();

                    assert workspace_list != null;
                    workspace_list.remove(workspacemodel);
                    usermodel.setWorkspaces(workspace_list);
                    userRepository.save(usermodel);

                }

            } catch (Exception err) {
                System.out.println("Cannot remove workspace from user");

            }

    }

}
