package cafe_strange.implementations.services.media;

import cafe_strange.interfaces.repositories.media.MediaRepo;
import cafe_strange.interfaces.repositories.media.PictureRepo;
import cafe_strange.interfaces.services.media.MediaService;
import cafe_strange.interfaces.services.media.PictureService;
import cafe_strange.models.extra.Category;
import cafe_strange.models.media.Media;
import cafe_strange.models.media.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
public class PictureServiceImp implements PictureService {

    @Autowired
    private EntityManager em;
    @Autowired
    private PictureRepo pictureRepo;
    @Autowired
    private MediaService mediaService;

    @Override
    public Picture findById(int id) {
        return pictureRepo.findById(id);
    }

    @Override
    public Picture findByUrl(String url) {
        return pictureRepo.findByUrl(url);
    }

    @Override
    public List<Picture> findAll() {
        return pictureRepo.findAll();
    }


    @Override
    public List<Picture> findByCategory(Category category) {
        return pictureRepo.findByCategory(category);
    }

    @Override
    public Picture uploadPicture(MultipartFile file, String folder, Category category) {
        String uploadFolder = "C:/gitmap/Eindwerk/Cafe-Strange/src/main/webapp/img/" + folder + "/";
        Media media = new Picture(file.getOriginalFilename().toString(),
                "hier moet caption komen", folder + "/" + file.getOriginalFilename(), category, true);
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFolder + file.getOriginalFilename());
            Files.write(path, bytes);
            mediaService.create(media);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Picture) media;
    }

    @Override
    public boolean update(Picture object) {
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
    public Picture create(Picture object) {
        return null;
    }

}

