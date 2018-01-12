package be.cafe_strange.implementations.services.media;

import be.cafe_strange.interfaces.services.media.PictureService;
import be.cafe_strange.models.Category;
import be.cafe_strange.models.media.Picture;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static be.cafe_strange.enums.MediaType.PICTURE;

@Service
@Transactional
public class PictureServiceImp extends MediaServiceImpl<Picture, List<Picture>> implements PictureService{

    private final String IMGFOLDER =  "C:/gitmap/Eindwerk/Cafe-Strange/src/main/webapp/img/";

    @Override
    public List<Picture> findAll() {
        return super.findAll(PICTURE);
    }

    @Override
    public Picture uploadPicture(MultipartFile file, String folder, Category category) {
        String uploadFolder = IMGFOLDER + folder + "/";
        int counter = 0;
        while (super.findByUrl(uploadFolder + file.getOriginalFilename().toString()) != null) {
            counter++;
            File newFile = new File(file.getOriginalFilename().toString() + String.valueOf(counter));
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Picture picture = new Picture(file.getOriginalFilename().toString(),
                "hier moet caption komen", uploadFolder + file.getOriginalFilename(), category, true);
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

    @Override
    public boolean delete(Picture picture) {
        try {
            picture = super.findByUrl(picture.getUrl());
            File file = new File(IMGFOLDER + picture.getUrl());
            System.out.println(IMGFOLDER + picture.getUrl());
            System.out.println("file wordt gedelete");
            file.delete();
            super.delete(picture.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

