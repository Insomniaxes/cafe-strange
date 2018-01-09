package be.cafe_strange.implementations.repositories.general;

import be.cafe_strange.models.main.GeneralInfo;
import be.cafe_strange.interfaces.repositories.general.GeneralInfoRepo;
import be.cafe_strange.models.main.GeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class GeneralInfoRepoImpl implements GeneralInfoRepo {

    @Autowired
    private EntityManager em;

    @Override
    public GeneralInfo findGeneralInfo() {
        GeneralInfo info = em.find(GeneralInfo.class, 1);
        em.detach(info);
        return info;
    }

    @Override
    public boolean update(GeneralInfo generalInfo) {
        try {
            em.merge(generalInfo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
