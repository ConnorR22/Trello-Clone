package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.task.entity.TaskModel;

import java.util.Date;
import java.util.List;

public interface IBoardService {
    BoardModel createBoard(BoardModel boardModel);

    BoardModel findBoardByID(int boardId);

    void deleteBoard(int boardId);

    List<BoardModel> getBoards();

    boolean addTaskToBoard(int boardId, String email);

    List<TaskModel> getTasks(int boardId);

    List<TaskModel> getTaskFiltered(int boardId, Date date, int when);
}
