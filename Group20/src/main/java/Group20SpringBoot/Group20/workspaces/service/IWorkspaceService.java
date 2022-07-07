package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.boards.entity.WorkspaceModel;

import java.util.List;
//import org.springframework.stereotype.Service;

public interface IWorkspaceService {
    Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel createWorkspace(Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel workspaceModel);

    Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel findWorkspaceByID(int workspaceId);

    Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel addBoard(int workspaceId, int boardId);

    Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel removeBoard(int workspaceId, int boardId);

    List<WorkspaceModel> getBoardsOfWorkspace(int workspaceId);

    void deleteWorkspace(int workspaceId);

    List<Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel> getUserWorkspaces(int userId);


    //sanjay
    void deleteUserFromWorkspace(int workspaceId, int userId);
    void addUserToWorkspace(int workspaceId, int userId);


}
