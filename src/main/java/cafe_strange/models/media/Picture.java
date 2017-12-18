package cafe_strange.models.media;

import cafe_strange.models.forum.Cattegory;

import javax.persistence.*;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "picture_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "caption")
    private String caption;
    @Column(name = "pictureURL")
    private String pictureURL;
    @OneToOne
    private Cattegory cattegory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Cattegory getCattegory() {
        return cattegory;
    }

    public void setCattegory(Cattegory cattegory) {
        this.cattegory = cattegory;
    }
}
