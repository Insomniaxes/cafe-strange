package cafe_strange.implementations.services.media;

import cafe_strange.interfaces.repositories.media.PictureRepo;
import cafe_strange.interfaces.services.media.PictureService;
import cafe_strange.models.extra.Category;
import cafe_strange.models.media.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class PictureServiceImp implements PictureService {

    @Autowired
    private EntityManager em;
    @Autowired
    private PictureRepo pictureRepo;

    @Override
    public Picture findById(int id) {
        return (Picture) pictureRepo.findById(id);
    }




    @Override
    public Picture findByUrl(String url) {
        return pictureRepo.findByUrl(url);
    }

    @Override
    public List<Picture> findAll() {
        return (List<Picture>) pictureRepo.findAll();
    }


    @Override
    public List<Picture> findByCategory(Category category) {
        return pictureRepo.findByCategory(category);
    }

    @Override
    public Picture uploadPicture(MultipartFile file, Picture picture, String folder) {
        String uploadFolder = "C:/gitmap/Eindwerk/Cafe-Strange/src/main/webapp/img/" + folder + "/";
        picture.setPictureURL(folder + "/" + file.getOriginalFilename());
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFolder + file.getOriginalFilename());
            Files.write(path, bytes);
            em.persist(picture);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return findByUrl(picture.getPictureURL());
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            em.remove(findById(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object create(Object object) {
        return null;
    }

}

