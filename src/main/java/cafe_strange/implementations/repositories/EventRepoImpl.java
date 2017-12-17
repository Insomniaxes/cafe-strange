package cafe_strange.implementations.repositories;

import cafe_strange.interfaces.repositories.EventRepo;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.SortedSet;

@Repository
@Transactional
public class EventRepoImpl implements EventRepo {

    @Autowired
    private EntityManager em;

    @Override
    public Event findEventById(int eventId) {
        return em.find(Event.class, eventId);
    }

    @Override
    public List<Event> findUpcomingEvents() {
        Query query = em.createQuery("SELECT e FROM Event AS e WHERE e.date >= :now");
        query.setParameter("now", java.sql.Date.valueOf(LocalDate.now()));
        return (List<Event>) query.getResultList();
    }

    @Override
    public List<Event> findPastEvents() {
        Query query = em.createQuery("SELECT e FROM Event AS e WHERE e.date < :now");
        query.setParameter("now", java.sql.Date.valueOf(LocalDate.now()));
        return (List<Event>) query.getResultList();
    }


}