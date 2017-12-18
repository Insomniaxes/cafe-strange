package cafe_strange.implementations.services;

import cafe_strange.interfaces.repositories.EventRepo;
import cafe_strange.interfaces.services.EventService;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
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

    @Override
    public void create(Event event) {
        eventRepo.create(event);
    }

}
