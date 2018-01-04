package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.models.event.News;
import be.cafe_strange.interfaces.main.MainInterface;
import be.cafe_strange.models.event.News;

import java.util.List;

public interface NewsRepo extends MainInterface<News, List<News>> {

}
