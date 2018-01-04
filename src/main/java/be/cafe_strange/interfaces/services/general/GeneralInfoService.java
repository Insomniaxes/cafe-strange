package be.cafe_strange.interfaces.services.general;

import be.cafe_strange.models.main.GeneralInfo;
import be.cafe_strange.models.main.GeneralInfo;

public interface GeneralInfoService {

    GeneralInfo findGeneralInfo();

    GeneralInfo findIntroInfo();

    boolean update(GeneralInfo info);

}
