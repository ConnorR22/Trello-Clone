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
//        assertEquals("daniaka@yahoo.com",rg_user.getEmailId());
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

//        HashMap<String, String> result = userService.loginUser("daniaka@yahoo.com","Password");
//        HashMap<String, String> expected= new HashMap<>();;
//        expected.put("result", "" + user.getUserId());
//        expected.put("status", "success");
//        assertEquals(expected,result);


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

//        HashMap<String, String> result = userService.loginUser("daniaka@yahoo.com","IamGroot");
//        HashMap<String, String> expected= new HashMap<>();;
//        expected.put("result", "Login unsuccessful");
//        expected.put("status", "Invalid Email or Password");
//        assertEquals(expected,result);


    }

    @Test
    void resetPasswordTestSuccess() {

        UserModel user = new UserModel();
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("YourOldPasswordandNewPasswordCannotbeSame");
        user.setSecretKey("SecretKey");

        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));

        boolean result = userService.resetPassword("daniaka@yahoo.com","SecretKey");
//        HashMap<String, String> expected= new HashMap<>();;
//        expected.put("result", "" + user.getUserId());
//        expected.put("status", "success");
        assertTrue(result);




    }
    @Test
    void resetPasswordTestFailure() {

        UserModel user = new UserModel();
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("YourOldPasswordandNewPasswordCannotbeSame");
        user.setSecretKey("SecretKey");

        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));

        boolean result = userService.resetPassword("daniaka@yahoo.com","~/~#");
        HashMap<String, String> expected= new HashMap<>();;
        expected.put("result", "Reset unsuccessful");
        expected.put("status", "Invalid Security Answer");
        assertEquals(expected,result);


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

        List<WorkspaceModel> demoUserWorkspace = userService.getUserWorkspaces(user.getUserId());
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
