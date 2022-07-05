package Group20SpringBoot.Group20.workspaces.service;

import Group20SpringBoot.Group20.boards.entity.BoardModel;
import Group20SpringBoot.Group20.boards.service.BoardService;
import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;
import Group20SpringBoot.Group20.workspaces.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService implements IWorkspaceService{
    private final WorkspaceRepository workspaceRepository;
    private final BoardService boardService;
    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository, BoardService boardService){
        this.workspaceRepository = workspaceRepository;
        this.boardService = boardService;
    }

    @Override
    public WorkspaceModel createWorkspace(@RequestBody WorkspaceModel workspaceModel) {
        return workspaceRepository.save(workspaceModel);
    }

    @Override
    public WorkspaceModel findWorkspaceByID(int workspaceId) {
        return null;
    }

    @Override
    public WorkspaceModel addBoard(int workspaceId, int boardId){
        WorkspaceModel updatedWorkspace = null;
        Optional<WorkspaceModel> workspace = null;

        try {
            workspace = workspaceRepository.findById(workspaceId);
            if (workspace.isPresent()){
                WorkspaceModel workspaceModel = workspace.get();
                BoardModel boardModel = boardService.findBoardByID(boardId);

                List<BoardModel> boards = workspaceModel.getBoards();
                if (boards == null){
                    boards = new ArrayList<>();
                }

                boards.add(boardModel);

                workspaceModel.setBoards(boards);

                updatedWorkspace = workspaceRepository.save(workspaceModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedWorkspace;
    }

    @Override
    public WorkspaceModel removeBoard(int workspaceId, int boardId){
        WorkspaceModel updatedWorkspace = null;
        Optional<WorkspaceModel> workspace = null;

        try {
            workspace = workspaceRepository.findById(workspaceId);
            if (workspace.isPresent()){
                WorkspaceModel workspaceModel = workspace.get();
                BoardModel boardModel = boardService.findBoardByID(boardId);

                List<BoardModel> boards = workspaceModel.getBoards();
                if (boards == null){
                    return workspaceModel;
                }

                boards.remove(boardModel);

                workspaceModel.setBoards(boards);

                updatedWorkspace = workspaceRepository.save(workspaceModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedWorkspace;
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
