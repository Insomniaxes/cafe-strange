package cafe_strange.models.extra;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private int commentId;
    @Column(name = "comment", nullable = false)
    private String comment;
    @Column(name = "commentCreateTimestamp")
    private Timestamp commentCreateTimestamp;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCommentCreateTimestamp() {
        return commentCreateTimestamp;
    }

    public void setCommentCreateTimestamp(Timestamp commentCreateTimestamp) {
        this.commentCreateTimestamp = commentCreateTimestamp;
    }
}
