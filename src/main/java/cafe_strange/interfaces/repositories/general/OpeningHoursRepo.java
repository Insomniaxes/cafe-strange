package cafe_strange.interfaces.repositories.general;

import cafe_strange.models.main.OpeningHours;

import java.util.List;

public interface OpeningHoursRepo {

    List<OpeningHours> findOpeningHours();
    boolean update(OpeningHours openingHours);

}
