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

}
