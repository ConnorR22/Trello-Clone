package Group20SpringBoot.Group20.workspaces.entity;

import Group20SpringBoot.Group20.boards.entity.BoardModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Workspace")
public class WorkspaceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workspaceId;

    private String workspaceTitle;

    private String workspaceDesc;

    @OneToMany(targetEntity = BoardModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BoardModel> boards;

    public WorkspaceModel(String workspaceTitle, String workspaceDesc) {
        this.workspaceTitle = workspaceTitle;
        this.workspaceDesc = workspaceDesc;
    }

    public WorkspaceModel() {

    }

    public int getWorkspaceId() {
        return workspaceId;
    }
    public String getWorkspaceTitle() {
        return workspaceTitle;
    }

    public void setWorkspaceTitle(String workspaceTitle) {
        this.workspaceTitle = workspaceTitle;
    }

    public String getWorkspaceDesc() {
        return workspaceDesc;
    }

    public void setWorkspaceDesc(String workspaceDesc) {
        this.workspaceDesc = workspaceDesc;
    }


    public List<BoardModel> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardModel> boards) {
        this.boards = boards;
    }
}
