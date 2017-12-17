package cafe_strange.implementations.services;

import cafe_strange.interfaces.repositories.GeneralInfoRepo;
import cafe_strange.interfaces.services.GeneralInfoService;
import cafe_strange.models.main.GeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GeneralInfoServiceImpl implements GeneralInfoService {

    @Autowired
    private GeneralInfoRepo generalInfoRepo;

    @Override
    public GeneralInfo findGeneralInfo() {
        return generalInfoRepo.findGeneralInfo();
    }

    @Override
    public void updatGeneralInfo(GeneralInfo generalInfo) {
        generalInfo.setId(1);
        generalInfoRepo.update(generalInfo);
    }
}
