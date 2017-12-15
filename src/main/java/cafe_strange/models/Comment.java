package cafe_strange.models;

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

}
