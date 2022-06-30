package Group20SpringBoot.Group20.workspaces.controller;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.service.IWorkspaceService;
import Group20SpringBoot.Group20.workspaces.service.WorkspaceService;
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

    @GetMapping("/get/{workspaceId}")
    public WorkspaceModel findWorkspaceByID(@PathVariable int workspaceId){
        return workspaceService.findWorkspaceByID(workspaceId);
    }

    @GetMapping("/getBoards/{workspaceId}")
    public List<BoardModel> getBoards(@PathVariable int workspaceId){
        WorkspaceModel workspace = workspaceService.findWorkspaceByID(workspaceId);
        return workspace.getBoards();
    }
}
