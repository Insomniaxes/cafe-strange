package cafe_strange.interfaces.services;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.event.Event;

import java.sql.Date;
import java.util.List;

public interface EventService extends MainInterface<Event, List<Event>>{

    Event findByDate(Date date);

    Event findNext();

    List<Event> findUpcoming();

    List<Event> findPast();

}
