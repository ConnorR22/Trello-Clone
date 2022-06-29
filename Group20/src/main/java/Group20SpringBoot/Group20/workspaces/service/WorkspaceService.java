package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.boards.repository.BoardRepository;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

}
