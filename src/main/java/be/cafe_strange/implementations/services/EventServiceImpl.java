package be.cafe_strange.implementations.services;

import be.cafe_strange.models.Event;
import be.cafe_strange.interfaces.repositories.EventRepo;
import be.cafe_strange.interfaces.services.EventService;
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
    public Event findById(int eventId) {
        return eventRepo.findById(eventId);
    }

    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Event findByDate(Date date) {
        return eventRepo.findByDate(date);
    }

    @Override
    public Event findNext() {
        List<Event> events = eventRepo.findUpcoming();
        if (events.size() == 0) {
            return new Event();
        } else {
            Collections.sort(events);
            return events.get(0);
        }
    }

    @Override
    public List<Event> findUpcoming() {
        List<Event> events = eventRepo.findUpcoming();
        if (events.size() == 0) {
            return new ArrayList<>();
        } else {
            Collections.sort(events);
            return events;
        }
    }

    @Override
    public List<Event> findPast() {
        return eventRepo.findPast();
    }

    @Override
    public Event create(Event event) {
        if (eventDateFree(event.getDate())) {
            return eventRepo.create(event);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Event event) {
        try {
            eventRepo.update(event);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int eventId) {
        try {
            eventRepo.delete(eventId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eventDateFree(Date date) {
        if (eventRepo.findByDate(date) == null) {
            return true;
        } else {
            return false;
        }
    }


}
