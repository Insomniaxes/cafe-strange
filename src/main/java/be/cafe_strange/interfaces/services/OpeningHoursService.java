package be.cafe_strange.interfaces.services;

import be.cafe_strange.models.OpeningHours;

import java.util.List;

public interface OpeningHoursService {

    List<OpeningHours> findOpeningHours();
    boolean update(OpeningHours openingHours);

}
