package Group20SpringBoot.Group20.boards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Board")
public class BoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="BoardID", nullable = false)
    private int boardId;

    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="WorkspaceID", nullable = false)
    private int workspaceId;

//    @Column(name="Board_Title", nullable = false)
    private String boardTitle;

//    @Column(name="Status", nullable = false)
    private String status;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="Order", nullable = false)
    private int order;

//    @Column(name="Updated_Date", nullable = false)
    private String updatedDate;

    public BoardModel(int boardId, int workspaceId, String boardTitle, String status, int order, String updatedDate) {
        this.boardId = boardId;
        this.workspaceId = workspaceId;
        this.boardTitle = boardTitle;
        this.status = status;
        this.order = order;
        this.updatedDate = updatedDate;
    }

//    public BoardModel(String boardTitle, String status, String updatedDate) {
//        this.boardTitle = boardTitle;
//        this.status = status;
//        this.workspaceId = 1;
//        this.updatedDate = updatedDate;
//    }

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
