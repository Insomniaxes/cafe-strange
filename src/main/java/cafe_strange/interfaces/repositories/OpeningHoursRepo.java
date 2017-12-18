package cafe_strange.interfaces.repositories;

import cafe_strange.models.main.OpeningHours;

import java.util.List;

public interface OpeningHoursRepo {

    List<OpeningHours> findOpeningHours();

}
