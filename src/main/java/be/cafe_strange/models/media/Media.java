package be.cafe_strange.models.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.models.extra.Category;
import be.cafe_strange.models.extra.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn(name = "mediaType")
@Table(name = "Media")
public class Media implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "media_id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "caption")
    private String caption;
    @Column(name = "url")
    private String url;
    @Column(name = "mediaType", nullable = false, updatable = false, insertable = false)
    private MediaType mediaType;
    @OneToOne
    private Category category;
    @Column(name = "aprove")
    private boolean aproved;
    @OneToMany
    private List<Comment> comments;

    public Media() {
    }

    public Media(String title, String caption, String url, MediaType mediaType, Category category, boolean aproved) {
        this.title = title;
        this.caption = caption;
        this.url = url;
        this.mediaType = mediaType;
        this.category = category;
        this.aproved = aproved;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isAproved() {
        return aproved;
    }

    public void setAproved(boolean aproved) {
        this.aproved = aproved;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
