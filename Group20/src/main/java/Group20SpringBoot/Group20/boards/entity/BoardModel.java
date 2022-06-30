package Group20SpringBoot.Group20.boards.entity;

import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;

import javax.persistence.*;

@Entity(name = "Board")
public class BoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne(targetEntity = WorkspaceModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private int workspaceId;

    private String boardTitle;

    private String status;

    public BoardModel(int workspaceId, String boardTitle, String status) {
        this.workspaceId = workspaceId;
        this.boardTitle = boardTitle;
        this.status = status;
    }


    public BoardModel() {

    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
