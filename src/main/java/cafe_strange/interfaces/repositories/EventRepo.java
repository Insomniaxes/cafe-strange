package cafe_strange.interfaces.repositories;

import cafe_strange.models.event.Event;

import java.sql.Date;
import java.util.List;

public interface EventRepo {

    Event findEventById(int eventId);

    Event findEventByDate(Date date);

    List<Event> findUpcomingEvents();

    List<Event> findPastEvents();

    void create(Event event);

    void update(Event event);

    void delete(int eventId);
}
