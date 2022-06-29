package Group20SpringBoot.Group20.workspaces.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Workspace")
public class WorkspaceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workspaceId;

    private String workspaceTitle;

    private String workspaceDesc;

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

    public WorkspaceModel(String workspaceTitle, String workspaceDesc) {
        this.workspaceTitle = workspaceTitle;
        this.workspaceDesc = workspaceDesc;
    }

    public WorkspaceModel() {

    }

    public int getWorkspaceId() {
        return workspaceId;
    }

}
