package cafe_strange.interfaces.services.general;

import cafe_strange.models.main.OpeningHours;

import java.util.List;

public interface OpeningHoursService {

    List<OpeningHours> findOpeningHours();
    boolean update(OpeningHours openingHours);

}
