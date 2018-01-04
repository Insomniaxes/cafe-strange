package be.cafe_strange.interfaces.services.general;

import be.cafe_strange.models.main.OpeningHours;
import be.cafe_strange.models.main.OpeningHours;

import java.util.List;

public interface OpeningHoursService {

    List<OpeningHours> findOpeningHours();
    boolean update(OpeningHours openingHours);

}
