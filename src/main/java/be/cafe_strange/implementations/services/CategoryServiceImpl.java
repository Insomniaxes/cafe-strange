package be.cafe_strange.implementations.services;

import be.cafe_strange.models.Category;
import be.cafe_strange.interfaces.repositories.CategoryRepo;
import be.cafe_strange.interfaces.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public boolean checkCategory(Category category) {
        if (!categoryRepo.checkCategory(category)) {
            create(category);
            return true;
        } else {
            return true;
        }
    }

    @Override
    public Category create(Category category) {
        return categoryRepo.create(category);
    }

    @Override
    public boolean update(Category category) {
        return categoryRepo.update(category);
    }

    @Override
    public boolean delete(int id) {
        return categoryRepo.delete(id);
    }
}
