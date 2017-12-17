package cafe_strange.interfaces.repositories;

import cafe_strange.models.main.GeneralInfo;

public interface GeneralInfoRepo {

    GeneralInfo findGeneralInfo();
    void update(GeneralInfo generalInfo);

}
