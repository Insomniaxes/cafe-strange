package cafe_strange.models.extra;

import javax.persistence.*;

@Entity
@Table(name = "forumSubject")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "forumSubject_id")
    private int id;
    @Column(name = "category")
    private String category;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
