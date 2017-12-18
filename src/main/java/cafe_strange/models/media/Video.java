package cafe_strange.models.media;

import cafe_strange.models.forum.Cattegory;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "video_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "caption")
    private String caption;
    @Column(name = "videoURL")
    private String videoURL;
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

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public Cattegory getCattegory() {
        return cattegory;
    }

    public void setCattegory(Cattegory cattegory) {
        this.cattegory = cattegory;
    }
}
