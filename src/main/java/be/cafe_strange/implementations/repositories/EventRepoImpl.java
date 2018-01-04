package be.cafe_strange.implementations.repositories;

import be.cafe_strange.models.event.Event;
import be.cafe_strange.interfaces.repositories.EventRepo;
import be.cafe_strange.models.event.Event;
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
    public Event findById(int eventId) {
        return em.find(Event.class, eventId);
    }

    @Override
    public List<Event> findAll() {
        Query query = em.createQuery("SELECT e FROM Event AS e");
        return query.getResultList();
    }

    @Override
    public Event findByDate(Date date) {
        Query query = em.createQuery("SELECT e FROM Event AS e WHERE e.date = :date");
        query.setParameter("date", date);
        try {
            return (Event) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Event> findUpcoming() {
        Query query = em.createQuery("SELECT e FROM Event AS e WHERE e.date >= :now");
        query.setParameter("now", java.sql.Date.valueOf(LocalDate.now()));
        return (List<Event>) query.getResultList();
    }

    @Override
    public List<Event> findPast() {
        Query query = em.createQuery("SELECT e FROM Event AS e WHERE e.date < :now");
        query.setParameter("now", java.sql.Date.valueOf(LocalDate.now()));
        return (List<Event>) query.getResultList();
    }

    @Override
    public Event create(Event event) {
        em.persist(event);
        return event;
    }

    @Override
    public boolean update(Event event) {
        try {
            em.merge(event);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int eventId) {
        try {
            em.remove(findById(eventId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
