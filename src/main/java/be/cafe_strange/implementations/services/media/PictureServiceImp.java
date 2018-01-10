package be.cafe_strange.implementations.services.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.services.media.PictureService;
import be.cafe_strange.models.Category;
import be.cafe_strange.models.media.Picture;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional
public class PictureServiceImp extends MediaServiceImpl<Picture, List<Picture>> implements PictureService{

    private List<Picture> pictures;

    @Override
    public List<Picture> findAll() {
        return super.findAllByMediaType(MediaType.PICTURE);
    }

    @Override
    public Picture uploadPicture(MultipartFile file, String folder, Category category) {
        String uploadFolder = "C:/gitmap/Eindwerk/Cafe-Strange/src/main/webapp/img/" + folder + "/";
        Picture picture = new Picture(file.getOriginalFilename().toString(),
                "hier moet caption komen", folder + "/" + file.getOriginalFilename(), category, true);
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFolder + file.getOriginalFilename());
            Files.write(path, bytes);
            create(picture);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picture;
    }

}

