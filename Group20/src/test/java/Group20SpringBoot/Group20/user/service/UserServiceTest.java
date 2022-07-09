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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    @Autowired
    private UserRepository userRepository;

    @Mock
    private WorkspaceService workspaceService;

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
    void addWorkspaceToUserTest() {


        UserModel user = new UserModel();
        user.setFirstName("Dani");
        user.setLastName("Rojas");
        user.setEmailId("daniaka@yahoo.com");
        List<WorkspaceModel> workspaces = new ArrayList<>();
        user.setWorkspaces(workspaces);

        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));

        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        boolean result = userService.addUserToWorkspace( user.getEmailId(), workspaceModel);
        assertTrue(result);

    }

    @Test
    void addWorkspaceToUserTestFail() {

        UserModel user = new UserModel();
        user.setFirstName("Dani");
        user.setLastName("Rojas");
        user.setEmailId("daniaka@yahoo.com");
        user.setPassword("Password");
        user.setSecretKey("SecretKey");

        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        Mockito.when(userRepository.findByEmailId(user.getEmailId())).thenReturn(Optional.of(user));
        userService.addUserToWorkspace(user.getEmailId(),workspaceModel);
        assertFalse(userService.addUserToWorkspace(user.getEmailId(),workspaceModel));
    }

    @Test
    void deleteWorkspaceFromUser() {

        UserModel userMock = mock(UserModel.class);
        WorkspaceModel workspaceMock = mock(WorkspaceModel.class);

        userService.deleteWorkspaceFromUser(userMock.getUserId(), workspaceMock);
        verify(userRepository).findById(userMock.getUserId());

    }

//    @Test
//    void deleteUserFromWorkspace() {
//        UserModel user = new UserModel();
//        user.setFirstName("Dani");
//        user.setLastName("Rojas");
//        user.setEmailId("daniaka@yahoo.com");
//        List<WorkspaceModel> workspaces = new ArrayList<>();
//        user.setWorkspaces(workspaces);
//
//        Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
//
//        WorkspaceModel workspaceModel = new WorkspaceModel();
//        workspaceModel.setWorkspaceTitle("Test");
//        workspaceModel.setWorkspaceDesc("TestingTests");
//
//
////        Mockito.when(userService.deleteWorkspaceFromUser(user.getUserId(), workspaceModel)).thenReturn(true);
//        Mockito.verify(userService, times(1)).deleteWorkspaceFromUser(user.);
//
//
//        boolean result = workspaceService.addUserToWorkspace(workspaceModel.getWorkspaceId(), user.getEmailId());
//        assertTrue(result);
//    }
}
