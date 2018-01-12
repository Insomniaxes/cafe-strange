package be.cafe_strange.interfaces.services;

import be.cafe_strange.models.Category;
import be.cafe_strange.interfaces.MainInterface;

import java.util.List;

public interface CategoryService extends MainInterface<Category, List<Category>>{

    Category findByCategoryName(String categoryName);

}
