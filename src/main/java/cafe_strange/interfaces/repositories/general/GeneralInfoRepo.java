package cafe_strange.interfaces.repositories.general;

import cafe_strange.models.main.GeneralInfo;

public interface GeneralInfoRepo {

    GeneralInfo findGeneralInfo();
    boolean update(GeneralInfo info);

}
