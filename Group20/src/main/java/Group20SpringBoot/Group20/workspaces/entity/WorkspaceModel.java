//package Group20SpringBoot.Group20.workspaces.entity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "Workspace")
//public class WorkspaceModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int workspaceId;
//
//    private String workspaceName;
//
//    private Date creationDate;
//
//    public WorkspaceModel(String workspaceName, Date creationDate) {
//        this.workspaceName = workspaceName;
//        this.creationDate = creationDate;
//    }
//
//    public WorkspaceModel() {
//
//    }
//
//    public int getWorkspaceId() {
//        return workspaceId;
//    }
//
//    public String getWorkspaceName() {
//        return workspaceName;
//    }
//
//    public void setWorkspaceName(String workspaceName) {
//        this.workspaceName = workspaceName;
//    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
//}
