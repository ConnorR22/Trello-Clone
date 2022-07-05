package Group20SpringBoot.Group20;

import Group20SpringBoot.Group20.user.entity.UserModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTests {
    // Tests ideas for UserService class

    // Test that a user has been added to the database successfully
    // Test that the system returns the correct warning in the case of a password that is too short
    // Test that the system returns the correct warning in the case of a password that doesn't contain an uppercase letter
    // Test that the system returns the correct warning in the case of a password that doesn't contain a lowercase letter
    // Test that the system returns the correct warning in the case of a password that doesn't contain a number
    // Test that the system returns the correct warning in the case of a password that doesn't contain a special character
    // Test that a user logging in with correct credentials gets redirected to the main boards' page
    // Test that a user logging in without the correct credentials gets the correct warning message
    // Test that forgot password redirects to the login page after resetting your password

    @Test
    void getFirstNameTest(){
        UserModel user = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@Abcd123", "Stephanie");

        String firstName = user.getFirstName();

        assertEquals(firstName, "Jane");
    }

    @Test
    void getLastNameTest(){
        UserModel user = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@Abcd123", "Stephanie");

        String lastName = user.getLastName();

        assertEquals(lastName, "Doe");
    }

    @Test
    void getEmailTest(){
        UserModel user = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@Abcd123", "Stephanie");

        String email = user.getEmailId();

        assertEquals(email, "jane@dal.ca");
    }

    @Test
    void getPasswordTest(){
        UserModel user = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@Abcd123", "Stephanie");

        String pass = user.getPassword();

        assertEquals(pass, "@Abcd123");
    }

    @Test
    void getSecretKeyTest(){
        UserModel user = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@Abcd123", "Stephanie");

        String secretKey = user.getSecretKey();

        assertEquals(secretKey, "Stephanie");
    }
}
