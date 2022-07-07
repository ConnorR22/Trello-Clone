package Group20SpringBoot.Group20.boards.service;

import Group20SpringBoot.Group20.boards.entity.WorkspaceModel;
import Group20SpringBoot.Group20.boards.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService implements IBoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public WorkspaceModel createBoard(@RequestBody WorkspaceModel boardModel) {
        return boardRepository.save(boardModel);
    }

    @Override
    public WorkspaceModel findBoardByID(int boardId) {
        WorkspaceModel boardModel = null;

        Optional<WorkspaceModel> optionalBoardModel = boardRepository.findById(boardId);
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
    public List<WorkspaceModel> getBoards() {
        return boardRepository.findAll();
    }

}
