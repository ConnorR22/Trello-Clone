package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.boards.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService implements IBoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

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
    public BoardModel updateBoard(int boardId, BoardModel boardModel) {
        BoardModel updatedBoard = findBoardByID(boardId);

        if (boardModel.getBoardTitle() != null){
            updatedBoard.setBoardTitle(boardModel.getBoardTitle());
        }
        if (boardModel.getStatus() != null){
            updatedBoard.setStatus(boardModel.getStatus());
        }

        return boardRepository.save(updatedBoard);
    }

    @Override
    public void deleteBoard(int boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public List<BoardModel> getWorkspaceBoards(int workspaceId) {
        return null;
    }

    @Override
    public List<BoardModel> getBoards() {
        return boardRepository.findAll();
    }

}
