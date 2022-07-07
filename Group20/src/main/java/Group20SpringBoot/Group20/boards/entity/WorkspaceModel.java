package Group20SpringBoot.Group20.boards.entity;

import javax.persistence.*;

@Entity
@Table(name = "Boards")
public class WorkspaceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    private String boardTitle;

    public WorkspaceModel(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public WorkspaceModel() {

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
