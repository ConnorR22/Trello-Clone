package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.repository.WorkspaceRepository;
import org.hibernate.jdbc.Work;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WorkspaceServiceTest {

    @Mock
    @Autowired
    private WorkspaceRepository workspaceRepository;

    @InjectMocks
    WorkspaceService workspaceService;

    @Test
    void createWorkspaceTest(){

        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        Mockito.when(workspaceRepository.save(workspaceModel)).thenReturn(workspaceModel);
        WorkspaceModel savedWorkspace = workspaceService.createWorkspace(workspaceModel);
        assertNotNull(savedWorkspace);


    }


    @Test
    void findWorkspaceByID() {
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        Mockito.when(workspaceRepository.findById(workspaceModel.getWorkspaceId())).thenReturn(Optional.of(workspaceModel));

        WorkspaceModel demoWorkspaceModel = workspaceService.findWorkspaceByID(workspaceModel.getWorkspaceId());
        assertNotNull(demoWorkspaceModel);
    }

    @Test
    void addBoard() {

    }

    @Test
    void removeBoard() {

    }

    @Test
    void getBoardsOfWorkspace() {

    }

    @Test
    void deleteWorkspace() {
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");
        workspaceRepository.save(workspaceModel);

        workspaceService.deleteWorkspace(workspaceModel.getWorkspaceId());
        assertFalse((workspaceRepository.existsById(workspaceModel.getWorkspaceId())));

    }

    @Test
    void addUserToWorkspace() {
    }

    @Test
    void deleteUserFromWorkspace() {
    }
}
