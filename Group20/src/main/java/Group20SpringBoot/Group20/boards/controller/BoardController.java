package Group20SpringBoot.Group20.boards.controller;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.boards.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/board")
public class BoardController {
    private final IBoardService boardService;

    @Autowired
    public BoardController(IBoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:3000")
    public BoardModel createBoard(@RequestBody BoardModel boardModel)
    {
        return boardService.createBoard(boardModel);
    }

    @GetMapping("/get/{boardId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public BoardModel findBoardByID(@PathVariable int boardId){
        return boardService.findBoardByID(boardId);
    }

    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<BoardModel> getAllBoards()
    {
        return boardService.getBoards();
    }

    @DeleteMapping("/delete/{boardId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteTask(@PathVariable int boardId)
    {
        boardService.deleteBoard(boardId);
    }

}
