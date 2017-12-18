package cafe_strange.implementations.services;

import cafe_strange.interfaces.repositories.EventRepo;
import cafe_strange.interfaces.services.EventService;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;

    @Override
    public Event findEventById(int eventId) {
        return eventRepo.findEventById(eventId);
    }

    @Override
    public Event findNextEvent() {
        List<Event> events = eventRepo.findUpcomingEvents();
        if (events.size() == 0) {
            return new Event();
        } else {
            Collections.sort(events);
            return events.get(0);
        }
    }

    @Override
    public List<Event> findUpcomingEvents() {
        return eventRepo.findUpcomingEvents();
    }

    @Override
    public List<Event> findPastEvents() {
        return eventRepo.findPastEvents();
    }

}
