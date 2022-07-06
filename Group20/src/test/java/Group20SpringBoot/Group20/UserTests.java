package Group20SpringBoot.Group20;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTests {
    @MockBean
    private UserRepository userRepository;



    // Tests ideas for UserService class
    // Mockito tests
    // Test that a user has been added to the database successfully
    @Test
    void registerUser() throws Exception {
        UserModel user = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@Abcd123", "Stephanie");

        String firstName = user.getFirstName();
        String email = user.getEmailId();
        String lastName = user.getLastName();


        assertEquals(firstName, "Jane");
        assertEquals(email, "janedoe@dal.ca");
        assertEquals(lastName, "Doe");

    }

    // Test that the system returns the correct warning in the case of a password that is too short
    @Test
    void passwordIsAtLeast8CharLong() {
        try {
            UserModel userModel = new UserModel("Jane", "Doe", "janedoe@dal.ca", "123", "Stephanie");

        } catch (Exception ex) {
            Logger.getLogger(UserTests.class.getName()).log(Level.SEVERE, null, ex);

            assertEquals(ex.getMessage(), "Password must be atleast 8 characters");
        }
    }

    // Test that the system returns the correct warning in the case of a password that doesn't contain an uppercase letter
    @Test
    void passwordMustContainUpperCaseChar() {
        try {
            UserModel userModel = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@abcd123", "Stephanie");

        } catch (Exception ex) {
            Logger.getLogger(UserTests.class.getName()).log(Level.SEVERE, null, ex);

            assertEquals(ex.getMessage(), "Password must contain uppercase character");
        }
    }

    // Test that the system returns the correct warning in the case of a password that doesn't contain a lowercase letter
    @Test
    void passwordMustContainLowerCaseChar() {
        try {
            UserModel userModel = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@ABCD123", "Stephanie");

        } catch (Exception ex) {
            Logger.getLogger(UserTests.class.getName()).log(Level.SEVERE, null, ex);

            assertEquals(ex.getMessage(), "Password must contain lowercase character");
        }
    }

    // Test that the system returns the correct warning in the case of a password that doesn't contain a number
    @Test
    void passwordMustContainANumber() {
        try {
            UserModel userModel = new UserModel("Jane", "Doe", "janedoe@dal.ca", "@ABCDabc", "Stephanie");

        } catch (Exception ex) {
            Logger.getLogger(UserTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}