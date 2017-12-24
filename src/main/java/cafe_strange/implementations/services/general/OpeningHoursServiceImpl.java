package cafe_strange.implementations.services.general;

import cafe_strange.interfaces.repositories.general.OpeningHoursRepo;
import cafe_strange.interfaces.services.general.OpeningHoursService;
import cafe_strange.models.main.OpeningHours;
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
