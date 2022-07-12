package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.boards.repository.BoardRepository;
import Group20SpringBoot.Group20.task.entity.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService implements IBoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public BoardModel createBoard(@RequestBody BoardModel boardModel) {
        return boardRepository.save(boardModel);
    }

    @Override
    public BoardModel findBoardByID(int boardId) {
        BoardModel boardModel = null;

        Optional<BoardModel> optionalBoardModel = boardRepository.findById(boardId);
        if(optionalBoardModel.isPresent())
        {
            boardModel = optionalBoardModel.get();
        }

        return boardModel;
    }


    @Override
    public void deleteBoard(int boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public List<BoardModel> getBoards() {
        return boardRepository.findAll();
    }

    @Override
    public boolean addTaskToBoard(int boardId, String email) {
        return false;
    }

    @Override
    public List<TaskModel> getTasks(int boardId) {
        return null;
    }

    @Override
    public List<TaskModel> getTaskFiltered(int boardId, Date date, int when) {
        return null;
    }

}
