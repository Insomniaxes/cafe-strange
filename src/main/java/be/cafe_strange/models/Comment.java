package be.cafe_strange.models;

import be.cafe_strange.models.user.User;

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
    @Column(name = "timestampCreation")
    private Timestamp timestampCreation;
    @ManyToOne
    private User user;

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

    public Timestamp getTimestampCreation() {
        return timestampCreation;
    }

    public void setTimestampCreation(Timestamp timestampCreation) {
        this.timestampCreation = timestampCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
