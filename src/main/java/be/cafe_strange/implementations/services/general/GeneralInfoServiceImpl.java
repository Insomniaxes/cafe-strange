package be.cafe_strange.implementations.services.general;

import be.cafe_strange.models.main.GeneralInfo;
import be.cafe_strange.interfaces.repositories.general.GeneralInfoRepo;
import be.cafe_strange.interfaces.services.general.GeneralInfoService;
import be.cafe_strange.models.main.GeneralInfo;
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
    public GeneralInfo findIntroInfo() {
        GeneralInfo info = findGeneralInfo();
        if (info.getExtendedInfo().length() > 250) {
            info.setExtendedInfo(info.getExtendedInfo().substring(0, 250) + "...<br><br><b><a href='/generalInfo'>Lees Meer</a></b>");
        }
        return info;
    }

    @Override
    public boolean update(GeneralInfo generalInfo) {
        generalInfo.setId(1);
        return generalInfoRepo.update(generalInfo);
    }

}