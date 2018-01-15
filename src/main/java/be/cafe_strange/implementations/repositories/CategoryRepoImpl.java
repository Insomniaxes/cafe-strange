package be.cafe_strange.implementations.repositories;

import be.cafe_strange.models.Category;
import be.cafe_strange.interfaces.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryRepoImpl implements CategoryRepo {

    @Autowired
    private EntityManager em;

    @Override
    public Category findById(int id) {
        return em.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        Query query = em.createQuery("SELECT c FROM Category as c");
        return query.getResultList();
    }

    @Override
    public boolean checkCategory(Category category) {
        Query query = em.createQuery("SELECT c FROM Category AS c WHERE c.category = :category");
        query.setParameter("category", category.getCategory());
        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public Category create(Category category) {
        em.persist(category);
        return category;
    }

    @Override
    public boolean update(Category category) {
        try {
            em.merge(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            em.remove(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
