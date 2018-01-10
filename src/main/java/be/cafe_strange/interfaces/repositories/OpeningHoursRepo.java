package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.models.OpeningHours;

import java.util.List;

public interface OpeningHoursRepo {

    List<OpeningHours> findOpeningHours();
    boolean update(OpeningHours openingHours);

}
