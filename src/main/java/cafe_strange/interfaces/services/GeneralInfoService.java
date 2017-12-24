package cafe_strange.interfaces.services;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.main.GeneralInfo;

import java.util.List;

public interface GeneralInfoService {

    GeneralInfo findGeneralInfo();

    GeneralInfo findIntroInfo();

    boolean update(GeneralInfo info);

}
