package Group20SpringBoot.Group20.user.entity;

import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String secretKey;

    @ManyToMany(targetEntity = WorkspaceModel.class)
    @JoinColumn(name = "workspaceMap")
    private List<WorkspaceModel> workspaces;

    public List<WorkspaceModel> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<WorkspaceModel> workspaces) {
        this.workspaces = workspaces;
    }

    public UserModel(String firstName, String lastName, String emailId, String password, String secretKey) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.secretKey = secretKey;
    }

    public UserModel(){

    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecretKey(String secretKeyAns) {
        this.secretKey = secretKeyAns;
    }

    public String getSecretKey() {
        return secretKey;
    }



}
