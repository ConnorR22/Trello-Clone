package Group20SpringBoot.Group20.boards.controller;

import Group20SpringBoot.Group20.boards.entity.WorkspaceModel;
import Group20SpringBoot.Group20.boards.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final IBoardService boardService;

    @Autowired
    public BoardController(IBoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/save")
    public WorkspaceModel createBoard(@RequestBody WorkspaceModel boardModel)
    {
        return boardService.createBoard(boardModel);
    }

    @GetMapping("/get/{boardId}")
    public WorkspaceModel findBoardByID(@PathVariable int boardId){
        return boardService.findBoardByID(boardId);
    }

    @GetMapping("/getAll")
    public List<WorkspaceModel> getAllBoards()
    {
        return boardService.getBoards();
    }

    @DeleteMapping("/delete/{boardId}")
    public void deleteTask(@PathVariable int boardId)
    {
        boardService.deleteBoard(boardId);
    }

}
