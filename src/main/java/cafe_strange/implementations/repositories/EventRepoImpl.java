package cafe_strange.implementations.repositories;

import cafe_strange.interfaces.repositories.EventRepo;
import cafe_strange.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
    public Event findEventByDate(Date date) {
        Query query = em.createQuery("SELECT e FROM Event AS e WHERE e.date = :date");
        query.setParameter("date", date);
        try {
            return (Event) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
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

    @Override
    public void create(Event event) {

        em.persist(event);
    }

    @Override
    public void update(Event event) {
        em.merge(event);
    }

    @Override
    public void delete(int eventId) {
        em.remove(findEventById(eventId));
    }
}
