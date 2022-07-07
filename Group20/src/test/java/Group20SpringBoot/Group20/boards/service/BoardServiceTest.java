package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.WorkspaceModel;
import Group20SpringBoot.Group20.boards.repository.BoardRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BoardServiceTest {


    @Mock
    @Autowired
    private BoardRepository boardRepository;

    @InjectMocks
    BoardService boardService;


    @Test
    void createBoardTest() {
        WorkspaceModel boardmodel = new WorkspaceModel();
        boardmodel.setBoardTitle("Test");

        when(boardRepository.save(boardmodel)).thenReturn(boardmodel);

        WorkspaceModel savedBoard = boardService.createBoard(boardmodel);
        assertNotNull(savedBoard);
    }

    @Test
    void findBoardByIDTest() {
        WorkspaceModel boardmodel = new WorkspaceModel();
        boardmodel.setBoardTitle("Test");

        Mockito.when(boardRepository.findById(boardmodel.getBoardId())).thenReturn(Optional.of(boardmodel));
        WorkspaceModel board = boardService.findBoardByID(boardmodel.getBoardId());
        assertNotNull(board);
    }

    @Test
    void deleteBoardTest() {

        WorkspaceModel boardmodel = new WorkspaceModel();
        boardmodel.setBoardTitle("Test");
        boardRepository.save(boardmodel);

        boardService.deleteBoard(boardmodel.getBoardId());
        assertFalse(boardRepository.existsById(boardmodel.getBoardId()));

    }

    @Test
    void getBoardsTest() {

        boardRepository.save(new WorkspaceModel("Test"));
        List<WorkspaceModel> boards = boardService.getBoards();
        assertNotNull(boards);

    }
}