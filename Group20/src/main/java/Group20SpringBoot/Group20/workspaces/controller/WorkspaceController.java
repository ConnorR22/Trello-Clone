//package Group20SpringBoot.Group20.workspaces.controller;
//
//import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
//import Group20SpringBoot.Group20.workspaces.service.IWorkspaceService;
//import Group20SpringBoot.Group20.workspaces.service.WorkspaceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class WorkspaceController {
//
//    @Autowired
//    private final IWorkspaceService workspaceService;
//
//    public WorkspaceController(IWorkspaceService workspaceService) {
//        this.workspaceService = workspaceService;
//    }
//
//    @PostMapping(path = "/addWorkspace", consumes = "application/json", produces = "application/json")
//    public WorkspaceModel addWorkspace(@RequestBody WorkspaceModel workspaceModel) {
//        return workspaceService.createWorkspace(workspaceModel);
//    }
//}
