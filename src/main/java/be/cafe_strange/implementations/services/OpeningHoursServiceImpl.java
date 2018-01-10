package be.cafe_strange.implementations.services;

import be.cafe_strange.models.OpeningHours;
import be.cafe_strange.interfaces.repositories.OpeningHoursRepo;
import be.cafe_strange.interfaces.services.OpeningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OpeningHoursServiceImpl implements OpeningHoursService {

    @Autowired
    private OpeningHoursRepo openingHoursRepo;

    @Override
    public List<OpeningHours> findOpeningHours() {
        return openingHoursRepo.findOpeningHours();
    }

    @Override
    public boolean update(OpeningHours openingHours) {
        return openingHoursRepo.update(openingHours);
    }

}
