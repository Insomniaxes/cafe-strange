package cafe_strange.interfaces.repositories;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.event.News;

import java.util.List;

public interface NewsRepo extends MainInterface<News, List<News>> {

}
