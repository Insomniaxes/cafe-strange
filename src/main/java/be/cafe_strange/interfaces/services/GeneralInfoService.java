package be.cafe_strange.interfaces.services;

import be.cafe_strange.models.GeneralInfo;

public interface GeneralInfoService {

    GeneralInfo findGeneralInfo();

    GeneralInfo findIntroInfo();

    boolean update(GeneralInfo info);

}
