package cafe_strange.interfaces.services;

import cafe_strange.models.main.GeneralInfo;

public interface GeneralInfoService {

    GeneralInfo findGeneralInfo();
    void updatGeneralInfo(GeneralInfo generalInfo);

}
