package Group20SpringBoot.Group20.user.service;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService implements IUserService {

    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserService() {}

    @Override
    public static UserModel saveUser(@RequestBody UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUser(int id) {
        long idLong = id;
        UserModel user = userRepository.findById(idLong).get();
        user.setSecretKey(null);
        return user;
    }






        public void signUp() {
        Scanner kb = new Scanner(System.in);

        System.out.println("What is your first name?");
        String firstName = kb.next();

        System.out.println("What is your last name?");
        String lastName = kb.next();

        System.out.println("Please enter your email");
        String email = kb.next();

        System.out.println("Please enter your password");
        System.out.println("Your password must contain:");
        System.out.println("At least 1 uppercase letter");
        System.out.println("At least 1 lowercase letter");
        System.out.println("At least 1 number");
        System.out.println("At least 1 special character");
        System.out.println("At least 8 or more characters");

        String password = kb.next();

        boolean upperCheck = false;
        boolean lowerCheck = false;
        boolean numberCheck = false;
        boolean lengthCheck = false;
        boolean specialCheck = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                upperCheck = true;
            } else {
                System.out.println("Password must contain at least 1 uppercase letter");
            }
            if (Character.isLowerCase(password.charAt(i))) {
                lowerCheck = true;
            } else {
                System.out.println("Password must contain at least 1 lowercase letter");
            }
            if (Character.isDigit(password.charAt(i))) {
                numberCheck = true;
            } else {
                System.out.println("Password must contain at least 1 number");
            }
            if (password.length() > 8) {
                lengthCheck = true;
            } else {
                System.out.println("Password must be at least 8 characters or more");
            }

            // https://www.w3schools.com/java/java_regex.asp
            //Date accessed: 30th June 2022
            //needed to understand how to use regex

            Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
            Matcher matcher = pattern.matcher(password);
            specialCheck = matcher.find();
            if (!specialCheck) {
                System.out.println("Password must contain at least 1 special character");
            }

        }

        System.out.println("What is the first name of your favourite teacher?");
        String securityAns = kb.next();

        boolean passwordCheck = upperCheck && lowerCheck && numberCheck && lengthCheck && specialCheck;

        if (passwordCheck) {
            UserModel user = new UserModel(firstName, lastName, email, password, securityAns);
            user.setSecretKey(securityAns);
            IUserService.saveUser(user);
        }


    }

    public void login(String emailId, String password) {
        List<UserModel> allUsers = getAllUsers();

        for (UserModel user : allUsers) {
            if (user.getEmailId().equals(emailId)) {
                if (user.getPassword().equals(password)) {
                    // Redirect user to the dashboard
                } else {
                    System.out.println("The provided password is incorrect");
                }
            } else {
                System.out.println("There is no account associated with " + emailId);
            }
        }
    }

    public void forgotPassword(String email) throws Exception {
        List<UserModel> allUsers = getAllUsers();
        UserModel toUse = new UserModel();

        Scanner kb = new Scanner(System.in);
        String newPassword = "";
        boolean isPresent = true;

        for (UserModel user : allUsers) {
            if (user.getEmailId().equals(email)) {
                toUse = user;
                break;
            } else {
                isPresent = false;
            }
        }

        if (!isPresent) {throw new Exception("There is no account associated with the given email.");}

        System.out.println("What is the first name of your favourite teacher?");
        String securityAns = kb.next();

        if (toUse.getSecretKey().equals(securityAns)) {
            System.out.println("Please enter a new password");
            System.out.println("Your password must contain:");
            System.out.println("At least 1 uppercase letter");
            System.out.println("At least 1 lowercase letter");
            System.out.println("At least 1 number");
            System.out.println("At least 1 special character");
            System.out.println("At least 8 or more characters");
            newPassword = kb.next();
            toUse.setPassword(newPassword);
            // Redirect to login page
        }
    }
}

