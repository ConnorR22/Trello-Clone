package Group20SpringBoot.Group20.boards.entity;

import javax.persistence.*;

@Entity(name = "Board")
public class BoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workspaceId;

    private String boardTitle;

    private String status;

    public BoardModel( String boardTitle, String status) {
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
