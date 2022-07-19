package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.task.entity.TaskModel;

import java.util.Date;
import java.util.List;

public interface IBoardService {
    BoardModel createBoard(BoardModel boardModel);

    BoardModel findBoardByID(int boardId);

    void deleteBoard(int boardId);

    boolean addTaskToBoard(int boardId, int taskId);

    List<TaskModel> getTasks(int boardId);

    List<TaskModel> getDateFiltered(int boardId, int when);

    List<TaskModel> getNameFiltered(int boardId, String filter);
}
