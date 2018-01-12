package be.cafe_strange.implementations.services.media;

import be.cafe_strange.interfaces.services.CategoryService;
import be.cafe_strange.interfaces.services.media.PictureService;
import be.cafe_strange.models.Category;
import be.cafe_strange.models.media.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static be.cafe_strange.enums.MediaType.PICTURE;

@Service
@Transactional
public class PictureServiceImp extends MediaServiceImpl<Picture, List<Picture>> implements PictureService {

    private final String IMGFOLDER = "C:/gitmap/Eindwerk/Cafe-Strange/src/main/webapp/img/";
    private ArrayList<Picture> newPictureList;
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Picture> findAll() {
        return super.findAll(PICTURE);
    }

    @Override
    public Picture uploadPicture(MultipartFile file, String folder, Category category) {
        String uploadFolder = IMGFOLDER + folder + "/";
        Picture picture = new Picture();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File dir = new File(uploadFolder);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String createdFileName = java.util.UUID.randomUUID().toString() + file.getContentType().replace("/", ".");
                File serverFile = new File(dir.getAbsolutePath() + "/" + createdFileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                picture = new Picture(file.getName(),
                        "hier moet caption komen", "img/" + folder + "/" + createdFileName, category, true);

                create(picture);
            } catch (IOException e) {
                e.printStackTrace();
                return new Picture();
            }
        }
        return picture;
    }

    @Override
    public List<Picture> uploadMultiplePictures(List<MultipartFile> multipartFiles, String folder, String categoryName) {
        newPictureList = new ArrayList<>();
        Category category = categoryService.findByCategoryName(categoryName);
        for (MultipartFile file : multipartFiles) {
            Picture picture = uploadPicture(file, "uploaded", category);
            newPictureList.add(picture);
        }
        return newPictureList;
    }

    @Override
    public boolean delete(Picture picture) {
        // todo deze functie terug aanpassen voor uploadfolder die niet meer zal kloppen
        try {
            picture = super.findByUrl(picture.getUrl());
            File file = new File(IMGFOLDER + picture.getUrl());
            System.out.println(IMGFOLDER + picture.getUrl());
            file.delete();
            super.delete(picture.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

