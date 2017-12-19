package cafe_strange.implementations.services;

import cafe_strange.interfaces.repositories.EventRepo;
import cafe_strange.interfaces.services.EventService;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
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
    public Event findEventByDate(Date date) {
        return eventRepo.findEventByDate(date);
    }

    public boolean eventDateFree(Date date) {
        if (eventRepo.findEventByDate(date) == null) {
            return true;
        } else {
            return false;
        }
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
        List<Event> events = eventRepo.findUpcomingEvents();
        if (events.size() == 0) {
            return new ArrayList<>();
        } else {
            Collections.sort(events);
            return events;
        }
    }

    @Override
    public List<Event> findPastEvents() {
        return eventRepo.findPastEvents();
    }

    @Override
    public boolean create(Event event) {
        if (eventDateFree(event.getDate())) {
            eventRepo.create(event);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void update(Event event) {
        eventRepo.update(event);
    }

    @Override
    public void delete(int eventId) {
        eventRepo.delete(eventId);
    }
}
