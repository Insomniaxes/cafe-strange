package cafe_strange.interfaces.services.general;

import cafe_strange.models.main.GeneralInfo;

public interface GeneralInfoService {

    GeneralInfo findGeneralInfo();

    GeneralInfo findIntroInfo();

    boolean update(GeneralInfo info);

}
