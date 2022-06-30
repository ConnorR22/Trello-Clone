package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService implements IWorkspaceService{
    private final WorkspaceRepository workspaceRepository;
    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository){
        this.workspaceRepository = workspaceRepository;
    }

    @Override
    public WorkspaceModel createWorkspace(@RequestBody WorkspaceModel workspaceModel) {
        return workspaceRepository.save(workspaceModel);
    }

    @Override
    public WorkspaceModel findWorkspaceByID(int workspaceId) {
        WorkspaceModel workspaceModel = null;

        Optional<WorkspaceModel> optionalWorkspaceModel = workspaceRepository.findById(workspaceId);
        if(optionalWorkspaceModel.isPresent())
        {
            workspaceModel = optionalWorkspaceModel.get();
        }

        return workspaceModel;
    }

    @Override
    public List<BoardModel> getBoardsOfWorkspace(int workspaceId) {
        WorkspaceModel workspace = findWorkspaceByID(workspaceId);

        return workspace.getBoards();
    }

    @Override
    public void deleteWorkspace(int workspaceId) {
        workspaceRepository.deleteById(workspaceId);
    }

    @Override
    public List<WorkspaceModel> getUserWorkspaces(int userId) {
        return null;
    }

}
