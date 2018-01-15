package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.models.Category;
import be.cafe_strange.interfaces.MainInterface;

import java.util.List;

public interface CategoryRepo extends MainInterface<Category, List<Category>> {

    Category findByCategoryName(String categoryName);

    boolean checkCategory(Category category);
}
