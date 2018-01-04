package be.cafe_strange.interfaces.repositories.general;

import be.cafe_strange.models.main.OpeningHours;
import be.cafe_strange.models.main.OpeningHours;

import java.util.List;

public interface OpeningHoursRepo {

    List<OpeningHours> findOpeningHours();
    boolean update(OpeningHours openingHours);

}
