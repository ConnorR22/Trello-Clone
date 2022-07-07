package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.WorkspaceModel;

import java.util.List;

public interface IBoardService {
    WorkspaceModel createBoard(WorkspaceModel boardModel);

    WorkspaceModel findBoardByID(int boardId);

//    BoardModel updateBoard(int boardId, BoardModel boardModel);

    void deleteBoard(int boardId);

    List<WorkspaceModel> getBoards();
}
