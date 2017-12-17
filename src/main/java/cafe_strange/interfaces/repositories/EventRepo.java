package cafe_strange.interfaces.repositories;

import cafe_strange.models.event.Event;

import java.util.List;

public interface EventRepo {

    Event findEventById(int eventId);
    List<Event> findUpcomingEvents();
    List<Event> findPastEvents();

}
