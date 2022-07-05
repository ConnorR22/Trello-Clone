package Group20SpringBoot.Group20.workspaces.controller;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.service.IWorkspaceService;
import Group20SpringBoot.Group20.workspaces.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workspace")
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

    @DeleteMapping("/removeBoard/{workspaceId}")
    public WorkspaceModel removeBoard(@PathVariable int workspaceId, @RequestParam int boardId) {
        return workspaceService.removeBoard(workspaceId, boardId);
    }
}
