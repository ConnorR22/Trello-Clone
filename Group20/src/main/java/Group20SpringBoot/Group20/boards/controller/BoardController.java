package Group20SpringBoot.Group20.boards.controller;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
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
    public BoardModel createBoard(@RequestBody BoardModel boardModel)
    {
        return boardService.createBoard(boardModel);
    }

//    @PutMapping("/update/{boardId}")
//    public BoardModel update(@PathVariable int boardId, @RequestBody BoardModel boardModel)
//    {
//        return boardService.updateBoard(boardId, boardModel);
//    }

    @GetMapping("/get/{boardId}")
    public BoardModel findBoardByID(@PathVariable int boardId){
        return boardService.findBoardByID(boardId);
    }

    @GetMapping("/getAll")
    public List<BoardModel> getAllBoards()
    {
        return boardService.getBoards();
    }

    @DeleteMapping("/delete/{boardId}")
    public void deleteTask(@PathVariable int boardId)
    {
        boardService.deleteBoard(boardId);
    }

}
