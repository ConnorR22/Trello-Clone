package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;

import java.util.List;
//import org.springframework.stereotype.Service;

public interface IWorkspaceService {
    WorkspaceModel createWorkspace(WorkspaceModel workspaceModel);

    WorkspaceModel findWorkspaceByID(int workspaceId);

    WorkspaceModel addBoard(int workspaceId, int boardId);

    WorkspaceModel removeBoard(int workspaceId, int boardId);

    List<BoardModel> getBoardsOfWorkspace(int workspaceId);

    void deleteWorkspace(int workspaceId);

    //sanjay
    void deleteUserFromWorkspace(int workspaceId, int userId);

//    List<WorkspaceModel> getUserWorkspaces(int userId);

    void addUserToWorkspace(int workspaceId, int userId);


}
