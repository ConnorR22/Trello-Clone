package Group20SpringBoot.Group20.boards.entity;
import javax.persistence.*;

@Entity
@Table(name = "Boards")
public class BoardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    private String boardTitle;

    private String boardDesc;



    public BoardModel(String boardTitle, String boardDesc) {
        this.boardTitle = boardTitle;
        this.boardDesc = boardDesc;
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

    public String getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc;
    }
}
