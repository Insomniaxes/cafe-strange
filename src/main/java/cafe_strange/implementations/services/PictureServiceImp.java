package cafe_strange.implementations.services;

import cafe_strange.interfaces.repositories.PictureRepo;
import cafe_strange.interfaces.services.PictureService;
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
    private Random random = new Random();
    private int counter = 0;
    private final int PICTURELIMIT = 6;

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private PictureRepo pictureRepo;

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
    public List<Picture> findMainPagePictures(boolean loggedin, String category) {
        List<Picture> allPictures = findAll();
        List<Picture> pictures = new ArrayList<>();
        counter = 0;
        if (loggedin) {
            if (category.equals("Main")) {
                if (allPictures.size() != 0) {
                    while (counter < PICTURELIMIT) {
                        pictures.add(allPictures.get(random.nextInt(allPictures.size())));
                        counter++;
                    }
                }
                return pictures;
            } else {
                allPictures = new ArrayList<>(findByCategory(category));
                if (allPictures.size() != 0) {
                    while (counter < PICTURELIMIT) {
                        pictures.add(allPictures.get(random.nextInt(allPictures.size())));
                        counter++;
                    }
                }
            }
            return pictures;
        } else {
            allPictures = findSafePictures();
            if (allPictures.size() != 0) {
                while (counter < PICTURELIMIT) {
                    pictures.add(allPictures.get(random.nextInt(allPictures.size())));
                    counter++;
                }
            }
        }
        return pictures;
    }

    @Override
    public List<Picture> findByCategory(String category) {
        return pictureRepo.findByCategory(category);
    }

    @Override
    public List<Picture> findSafePictures() {
        return pictureRepo.findSafePictures();
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
    public void deletePicture(Picture picture) {
        em.remove(picture);
    }

    private boolean pictureExists(Picture picture) {
        if (findByUrl(picture.getPictureURL()).getId() != 0) {
            return true;
        } else {
            return false;
        }
    }


}

