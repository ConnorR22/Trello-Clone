package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.boards.repository.BoardRepository;
import Group20SpringBoot.Group20.task.entity.TaskModel;
import Group20SpringBoot.Group20.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService implements IBoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TaskService taskService;

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
    public boolean addTaskToBoard(int boardId, int taskId) {
        BoardModel updatedBoard = null;
        Optional<BoardModel> optionalBoardModel = null;
        boolean result = false;

        try {
            optionalBoardModel = boardRepository.findById(boardId);
            if (optionalBoardModel.isPresent()){
                updatedBoard = optionalBoardModel.get();
                TaskModel task = taskService.findTaskByID(taskId);

                List<TaskModel> tasks = updatedBoard.getTasks();
                if (tasks == null){
                    tasks = new ArrayList<>();
                }

                tasks.add(task);
                updatedBoard.setTasks(tasks);

                boardRepository.save(updatedBoard);

                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<TaskModel> getTasks(int boardId) {
        BoardModel board = findBoardByID(boardId);
        return board.getTasks();
    }

    @Override
    public List<TaskModel> getTaskFiltered(int boardId, Date date, int when) {
        return null;
    }

}
