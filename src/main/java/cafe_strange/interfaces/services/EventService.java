package cafe_strange.interfaces.services;

import cafe_strange.models.event.Event;

import java.util.List;

public interface EventService {

    Event findEventById(int eventId);
    Event findNextEvent();
    List<Event> findUpcomingEvents();
    List<Event> findPastEvents();

}
