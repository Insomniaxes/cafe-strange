package be.cafe_strange.models.event;

import be.cafe_strange.models.media.Media;
import be.cafe_strange.models.media.Media;
import be.cafe_strange.models.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Event implements Comparable<Event> {

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
    @Column(name = "description")
    private String description;
    @OneToOne
    private Media picture;
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

    public Media getPicture() {
        return picture;
    }

    public void setPicture(Media picture) {
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
}
