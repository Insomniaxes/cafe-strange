package cafe_strange.implementations.services.extra;

import cafe_strange.interfaces.repositories.extra.CategoryRepo;
import cafe_strange.interfaces.services.extra.CategoryService;
import cafe_strange.models.extra.Category;
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
