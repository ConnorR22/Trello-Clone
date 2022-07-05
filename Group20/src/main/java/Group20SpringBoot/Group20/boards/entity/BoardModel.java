package Group20SpringBoot.Group20.boards.entity;

import Group20SpringBoot.Group20.workspaces.entity.WorkspaceModel;

import javax.persistence.*;

@Entity(name = "Board")
public class BoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    private String boardTitle;

    public BoardModel(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public BoardModel() {

    }

    public int getBoardId() {
        return boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

}
