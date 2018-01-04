package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.models.event.Event;
import be.cafe_strange.interfaces.main.MainInterface;
import be.cafe_strange.models.event.Event;

import java.sql.Date;
import java.util.List;

public interface EventRepo extends MainInterface<Event, List<Event>> {

    Event findByDate(Date date);

    List<Event> findUpcoming();

    List<Event> findPast();

}
