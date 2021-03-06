package be.cafe_strange.implementations.repositories;

import be.cafe_strange.models.OpeningHours;
import be.cafe_strange.interfaces.repositories.OpeningHoursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OpeningHoursRepoImpl implements OpeningHoursRepo {

    @Autowired
    private EntityManager em;

    @Override
    public List<OpeningHours> findOpeningHours() {
        Query query = em.createQuery("SELECT o FROM OpeningHours AS o");
        return (List<OpeningHours>) query.getResultList();
    }

    @Override
    public boolean update(OpeningHours openingHours) {
        try {
            em.merge(openingHours);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
