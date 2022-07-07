package Group20SpringBoot.Group20.workspaces.controller;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.service.IWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkspaceController {


    private final IWorkspaceService workspaceService;
    @Autowired
    public WorkspaceController(IWorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @PostMapping("/save")
    public WorkspaceModel addWorkspace(@RequestBody WorkspaceModel workspaceModel) {
        return workspaceService.createWorkspace(workspaceModel);
    }

    @PutMapping("/addBoard/{workspaceId}")
    public WorkspaceModel addBoard(@PathVariable int workspaceId, @RequestParam int boardId) {
        return workspaceService.addBoard(workspaceId, boardId);
    }

    @GetMapping("/getBoards/{workspaceId}")
    public List<BoardModel> getBoards(@PathVariable int workspaceId) {
        return workspaceService.getBoardsOfWorkspace(workspaceId);
    }

    @DeleteMapping("/removeBoard/{workspaceId}")
    public Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel removeBoard(@PathVariable int workspaceId, @RequestParam int boardId) {
        return workspaceService.removeBoard(workspaceId, boardId);
    }

    //sanjay
//    @PutMapping("/addUser/{userId}")
//    public void addUserToWorkspace(@PathVariable int workspaceId, @RequestParam int userId){
//        workspaceService.addUserToWorkspace(workspaceId, userId);
//    }
//    @PutMapping ("/deleteUser/{userId}")
//    public void deleteUserFromWorkspace(@PathVariable int workspaceId, @RequestParam int userId){
//        workspaceService.deleteUserFromWorkspace(workspaceId, userId);
//    }


}
