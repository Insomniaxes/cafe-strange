package be.cafe_strange.interfaces.repositories.general;

import be.cafe_strange.models.main.GeneralInfo;
import be.cafe_strange.models.main.GeneralInfo;

public interface GeneralInfoRepo {

    GeneralInfo findGeneralInfo();
    boolean update(GeneralInfo info);

}
