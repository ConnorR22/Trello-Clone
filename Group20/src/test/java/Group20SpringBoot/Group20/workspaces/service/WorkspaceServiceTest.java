package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.boards.service.BoardService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WorkspaceServiceTest {

    @Mock
    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Mock
    @Autowired
    private BoardService boardService = new BoardService();

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
    void addBoardTest() {
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        Mockito.when(workspaceRepository.findById(workspaceModel.getWorkspaceId())).thenReturn(Optional.of(workspaceModel));

        BoardModel boardmodel = new BoardModel();
        boardmodel.setBoardTitle("Test");

        Mockito.when(boardService.findBoardByID(boardmodel.getBoardId())).thenReturn(boardmodel);

        workspaceService.addBoard(workspaceModel.getWorkspaceId(), boardmodel.getBoardId());
        assertEquals(boardmodel, workspaceModel.getBoards().get(0));
    }

    @Test
    void removeBoardTest() {
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        BoardModel boardmodel = new BoardModel();
        boardmodel.setBoardTitle("Test");
        List<BoardModel> boards = new ArrayList<>();
        boards.add(boardmodel);
        workspaceModel.setBoards(boards);

        Mockito.when(workspaceRepository.findById(workspaceModel.getWorkspaceId())).thenReturn(Optional.of(workspaceModel));
        Mockito.when(boardService.findBoardByID(boardmodel.getBoardId())).thenReturn(boardmodel);

        workspaceService.removeBoard(workspaceModel.getWorkspaceId(), boardmodel.getBoardId());

        assertEquals(0, workspaceModel.getBoards().size());
    }

    @Test
    void getBoardsOfWorkspaceTest() {
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        BoardModel boardmodel = new BoardModel();
        boardmodel.setBoardTitle("Test");
        List<BoardModel> boards = new ArrayList<>();
        boards.add(boardmodel);
        workspaceModel.setBoards(boards);

        Mockito.when(workspaceRepository.findById(workspaceModel.getWorkspaceId())).thenReturn(Optional.of(workspaceModel));

        assertEquals(boards, workspaceService.getBoardsOfWorkspace(workspaceModel.getWorkspaceId()));
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
        WorkspaceModel workspaceModel = new WorkspaceModel();
        workspaceModel.setWorkspaceTitle("Test");
        workspaceModel.setWorkspaceDesc("TestingTests");

        Mockito.when(workspaceRepository.findById(workspaceModel.getWorkspaceId())).thenReturn(Optional.of(workspaceModel));

        BoardModel boardmodel = new BoardModel();
        boardmodel.setBoardTitle("Test");

        Mockito.when(boardService.findBoardByID(boardmodel.getBoardId())).thenReturn(boardmodel);

    }

    @Test
    void deleteUserFromWorkspace() {

    }
}
