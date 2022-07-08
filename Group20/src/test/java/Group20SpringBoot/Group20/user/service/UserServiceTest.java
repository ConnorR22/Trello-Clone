package Group20SpringBoot.Group20.user.service;

import Group20SpringBoot.Group20.user.entity.UserModel;
import Group20SpringBoot.Group20.user.repository.UserRepository;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.service.WorkspaceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    @Autowired
    private UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    void registerUserTest() {

        UserModel user = new UserModel();
        user.setFirstName("Dani");
        user.setLastName("Rojas");
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("Password");
        user.setSecretKey("SecretKey");

        Mockito.when(userRepository.save(user)).thenReturn(user);
        boolean rg_user = userService.registerUser(user);
        assertTrue(rg_user);

    }

    @Test
    void loginUserTestSuccess(){

        UserModel user = new UserModel();
        user.setFirstName("Dani");
        user.setLastName("Rojas");
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("Password");
        user.setSecretKey("SecretKey");
        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));

        int result = userService.loginUser("daniaka@yahoo.com","Password");

//        String expected = "0";
        assertEquals(0, result);

    }

    @Test
    void loginUserTestFailure(){

        UserModel user = new UserModel();
        user.setFirstName("Dani");
        user.setLastName("Rojas");
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("Password");
        user.setSecretKey("SecretKey");

        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));

        int result = userService.loginUser("daniaka@yahoo.com","WrongPassword");

//        String expected = "Login unsuccessful, email or password incorrect.";
        assertEquals(-1, result);


    }

    @Test
    void resetPasswordTestSuccess() {

        UserModel user = new UserModel();
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("YourOldPasswordandNewPasswordCannotbeSame");
        user.setSecretKey("SecretKey");

        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));

        int result = userService.resetPassword("daniaka@yahoo.com","SecretKey");

        assertEquals(0, result);

    }
    @Test
    void resetPasswordTestFailure() {

        UserModel user = new UserModel();
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("YourOldPasswordandNewPasswordCannotbeSame");
        user.setSecretKey("SecretKey");

        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));

        int result = userService.resetPassword("daniaka@yahoo.com","~/~#");
//        String expected = "Incorrect security answer.";
        assertEquals(-1, result);


    }

    @Test
    void findUserById() {

        UserModel user = new UserModel();
        user.setFirstName("Dani");
        user.setLastName("Rojas");
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("Password");
        user.setSecretKey("SecretKey");

        Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        UserModel demo = userService.findUserById(user.getUserId());
        assertNotNull(demo);


    }


    @Test
    void getUserWorkspacesTest() {

        UserModel user = new UserModel();
        user.setFirstName("Dani");
        user.setLastName("Rojas");
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("Password");
        user.setSecretKey("SecretKey");

        WorkspaceModel workspacemodel = new WorkspaceModel();
        workspacemodel.setWorkspaceDesc("Testing workspace");
        workspacemodel.setWorkspaceTitle("Tests");

        List<WorkspaceModel> workspace = new ArrayList<>();
        workspace.add(workspacemodel);
        user.setWorkspaces(workspace);

        Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

        List<WorkspaceModel> demoUserWorkspace = userService.getWorkspaces(user.getUserId());
        assertNotNull(demoUserWorkspace);
        assertEquals(demoUserWorkspace,user.getWorkspaces());

    }

    @Test
    void addWorkspaceToUser() {

    }
    @Test
    void deleteWorkspaceFromUser() {
    }
}
