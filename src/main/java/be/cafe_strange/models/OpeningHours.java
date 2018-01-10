package be.cafe_strange.models;

import be.cafe_strange.enums.Weekday;

import javax.persistence.*;

@Entity
public class OpeningHours {

    @Id
    @Enumerated(value = EnumType.ORDINAL)
    private Weekday weekday;
    @Column(name = "open")
    private String open;
    @Column(name = "closed")
    private String closed;

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }
}
