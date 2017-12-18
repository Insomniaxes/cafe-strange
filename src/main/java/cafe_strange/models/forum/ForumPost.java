package cafe_strange.models.forum;

import cafe_strange.models.Comment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "forumPost")
public class ForumPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int postId;
    @Column(name = "post", nullable = false)
    private String post;
    @Column(name = "postCreateTimestamp")
    private Timestamp postCreateTimestamp;
    @OneToMany
    private List<Comment> comments;
    @OneToOne
    private ForumSubject subject;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Timestamp getPostCreateTimestamp() {
        return postCreateTimestamp;
    }

    public void setPostCreateTimestamp(Timestamp postCreateTimestamp) {
        this.postCreateTimestamp = postCreateTimestamp;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ForumSubject getSubject() {
        return subject;
    }

    public void setSubject(ForumSubject subject) {
        this.subject = subject;
    }
}
