package cafe_strange.interfaces.repositories;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.main.GeneralInfo;

import java.util.List;

public interface GeneralInfoRepo {

    GeneralInfo findGeneralInfo();
    boolean update(GeneralInfo info);

}
