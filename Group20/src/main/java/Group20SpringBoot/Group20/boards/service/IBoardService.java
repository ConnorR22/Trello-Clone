package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;

import java.util.List;

public interface IBoardService {
    BoardModel createBoard(BoardModel boardModel);

    BoardModel findBoardByID(int boardId);

    List<BoardModel> getBoards(int workspaceId);

    void deleteBoard(int boardId);

}
