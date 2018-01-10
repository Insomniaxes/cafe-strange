package be.cafe_strange.models.event;

import be.cafe_strange.models.media.Picture;
import be.cafe_strange.models.media.Picture;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "news_id")
    private int id;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "intro", nullable = false, columnDefinition = "LONGTEXT")
    private String intro;
    @Column(name = "article", nullable = false, columnDefinition = "LONGTEXT")
    private String article;
    @Column(name = "source", nullable = false)
    private String source;
    @OneToMany
    private List<Picture> pictures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
