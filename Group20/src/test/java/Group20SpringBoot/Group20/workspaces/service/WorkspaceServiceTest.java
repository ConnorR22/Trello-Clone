package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.repository.WorkspaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
class WorkspaceServiceTest {

    @Mock
    @Autowired
    private WorkspaceRepository workspaceRepository;

    @InjectMocks
    WorkspaceService workspaceService;

    @Test
    void createWorkspaceTest() {

        WorkspaceModel workspaceModel = new WorkspaceModel();
    }

    @Test
    void findWorkspaceByID() {
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
    }





    @Test
    void addUserToWorkspace() {
    }

    @Test
    void deleteUserFromWorkspace() {
    }
}