package Group20SpringBoot.Group20.user.service;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel registerUser(UserModel usermodel) {

        Optional<UserModel> optionalUserModel = userRepository.findByEmailId(usermodel.getEmailId());
        if (optionalUserModel.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exists With that Email.");
        }

        return userRepository.save(usermodel);
    }

    @Override
    public HashMap<String, String> loginUser(String email, String password) {
        HashMap<String, String> request = new HashMap<>();

        UserModel user = null;
        Optional<UserModel> optionalUserModel = userRepository.findByEmailId(email);
        if (optionalUserModel.isPresent()){
            user = optionalUserModel.get();
            if (user.getPassword().equals(password)){
                request.put("result", ""+user.getId());
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

        if (optionalUserModel.isPresent()){
            user = optionalUserModel.get();

            // If security answer matches, register the new password
            if (user.getSecretKey().equals(securityAnswer)){
                user.setPassword(newPass);
                userRepository.save(user);

                request.put("result", ""+user.getId());
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

    @Override
    public boolean addUserToWorkspace(String email, WorkspaceModel workspace) {
        UserModel user = null;
        Optional<UserModel> optionalUserModel = userRepository.findByEmailId(email);

        if (optionalUserModel.isPresent()){
            user = optionalUserModel.get();

            List<WorkspaceModel> workspaces = user.getWorkspaces();
            if (workspaces == null){
                workspaces = new ArrayList<>();
            }

            if (workspaces.contains(workspace)){
                workspaces.add(workspace);
                user.setWorkspaces(workspaces);
                userRepository.save(user);

                return true;
            }
        }

        return false;
    }

    @Override
    public List<WorkspaceModel> getWorkspaces(int userId) {
        UserModel user = findUserById(userId);
        return user.getWorkspaces();
    }

    @Override
    public UserModel findUserById(int userId) {
        UserModel user = null;
        Optional<UserModel> optionalUserModel = userRepository.findById(userId);

        if (optionalUserModel.isPresent()){
            user = optionalUserModel.get();
        }
        return user;
    }

//    public UserModel getUser(int id) {
//        long idLong = id;
//        UserModel user = userRepository.findById(idLong).get();
//        user.setSecretKey(null);
//        return user;
//    }

//        public void signUp() {
//        Scanner kb = new Scanner(System.in);
//
//        System.out.println("What is your first name?");
//        String firstName = kb.next();
//
//        System.out.println("What is your last name?");
//        String lastName = kb.next();
//
//        System.out.println("Please enter your email");
//        String email = kb.next();
//
//        System.out.println("Please enter your password");
//        System.out.println("Your password must contain:");
//        System.out.println("At least 1 uppercase letter");
//        System.out.println("At least 1 lowercase letter");
//        System.out.println("At least 1 number");
//        System.out.println("At least 1 special character");
//        System.out.println("At least 8 or more characters");
//
//        String password = kb.next();
//
//        boolean upperCheck = false;
//        boolean lowerCheck = false;
//        boolean numberCheck = false;
//        boolean lengthCheck = false;
//        boolean specialCheck = false;
//
//        for (int i = 0; i < password.length(); i++) {
//            if (Character.isUpperCase(password.charAt(i))) {
//                upperCheck = true;
//            } else {
//                System.out.println("Password must contain at least 1 uppercase letter");
//            }
//            if (Character.isLowerCase(password.charAt(i))) {
//                lowerCheck = true;
//            } else {
//                System.out.println("Password must contain at least 1 lowercase letter");
//            }
//            if (Character.isDigit(password.charAt(i))) {
//                numberCheck = true;
//            } else {
//                System.out.println("Password must contain at least 1 number");
//            }
//            if (password.length() > 8) {
//                lengthCheck = true;
//            } else {
//                System.out.println("Password must be at least 8 characters or more");
//            }
//
//            // https://www.w3schools.com/java/java_regex.asp
//            //Date accessed: 30th June 2022
//            //needed to understand how to use regex
//
//            Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
//            Matcher matcher = pattern.matcher(password);
//            specialCheck = matcher.find();
//            if (!specialCheck) {
//                System.out.println("Password must contain at least 1 special character");
//            }
//
//        }
//
//        System.out.println("What is the first name of your favourite teacher?");
//        String securityAns = kb.next();
//
//        boolean passwordCheck = upperCheck && lowerCheck && numberCheck && lengthCheck && specialCheck;
//
//        if (passwordCheck) {
//            UserModel user = new UserModel(firstName, lastName, email, password, securityAns);
//            user.setSecretKey(securityAns);
//            IUserService.saveUser(user);
//        }
//
//
//}

//    public void login(String emailId, String password) {
//        List<UserModel> allUsers = getAllUsers();
//
//        for (UserModel user : allUsers) {
//            if (user.getEmailId().equals(emailId)) {
//                if (user.getPassword().equals(password)) {
//                    // Redirect user to the dashboard
//                } else {
//                    System.out.println("The provided password is incorrect");
//                }
//            } else {
//                System.out.println("There is no account associated with " + emailId);
//            }
//        }
//    }

//    public void forgotPassword(String email) throws Exception {
//        List<UserModel> allUsers = getAllUsers();
//        UserModel toUse = new UserModel();
//
//        Scanner kb = new Scanner(System.in);
//        String newPassword = "";
//        boolean isPresent = true;
//
//        for (UserModel user : allUsers) {
//            if (user.getEmailId().equals(email)) {
//                toUse = user;
//                break;
//            } else {
//                isPresent = false;
//            }
//        }
//
//        if (!isPresent) {throw new Exception("There is no account associated with the given email.");}
//
//        System.out.println("What is the first name of your favourite teacher?");
//        String securityAns = kb.next();
//
//        if (toUse.getSecretKey().equals(securityAns)) {
//            System.out.println("Please enter a new password");
//            System.out.println("Your password must contain:");
//            System.out.println("At least 1 uppercase letter");
//            System.out.println("At least 1 lowercase letter");
//            System.out.println("At least 1 number");
//            System.out.println("At least 1 special character");
//            System.out.println("At least 8 or more characters");
//            newPassword = kb.next();
//            toUse.setPassword(newPassword);
//            // Redirect to login page
//        }
//    }
}

