package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.models.GeneralInfo;

public interface GeneralInfoRepo {

    GeneralInfo findGeneralInfo();
    boolean update(GeneralInfo info);

}
