package cafe_strange.models.forum;

import javax.persistence.*;

@Entity
@Table(name = "forumSubject")
public class Cattegory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "forumSubject_id")
    private int id;
    @Column(name = "cattegory")
    private String subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
