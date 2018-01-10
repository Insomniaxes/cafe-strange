package be.cafe_strange.interfaces.services;

import be.cafe_strange.models.Event;
import be.cafe_strange.interfaces.MainInterface;

import java.sql.Date;
import java.util.List;

public interface EventService extends MainInterface<Event, List<Event>>{

    Event findByDate(Date date);

    Event findNext();

    List<Event> findUpcoming();

    List<Event> findPast();

}
