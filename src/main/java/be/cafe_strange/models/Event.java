package be.cafe_strange.models;

import be.cafe_strange.interfaces.Commentable;
import be.cafe_strange.interfaces.Likeable;
import be.cafe_strange.models.media.Media;
import be.cafe_strange.models.media.Picture;
import be.cafe_strange.models.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Event implements Comparable<Event>, Likeable, Commentable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private int id;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "summary", nullable = false)
    private String summary;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    @OneToOne
    private Picture picture;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    @Column(name = "participants")
    private List<User> participants;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @Override
    public int compareTo(Event o) {
        return getDate().compareTo(o.getDate());
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }
}
