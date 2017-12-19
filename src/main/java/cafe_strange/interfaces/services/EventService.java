package cafe_strange.interfaces.services;

import cafe_strange.models.event.Event;

import java.sql.Date;
import java.util.List;

public interface EventService {

    Event findEventById(int eventId);

    Event findEventByDate(Date date);

    Event findNextEvent();

    List<Event> findUpcomingEvents();

    List<Event> findPastEvents();

    boolean create(Event event);

    void update(Event event);

    void delete(int eventId);
}
