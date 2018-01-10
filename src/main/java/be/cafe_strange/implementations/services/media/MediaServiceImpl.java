package be.cafe_strange.implementations.services.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.repositories.MediaRepo;
import be.cafe_strange.interfaces.services.media.MediaService;
import be.cafe_strange.models.Category;
import be.cafe_strange.models.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public class MediaServiceImpl<T, L> implements MediaService<T, L> {

    @Autowired
    private MediaRepo<T,L> mediaRepo;

    @Override
    public T findById(int id) {
        return mediaRepo.findById(id);
    }

    @Override
    public L findAll() {
        return mediaRepo.findAll();
    }

    @Override
    public L findAllByMediaType(MediaType mediaType) {
        return mediaRepo.findAllByMediaType(mediaType);
    }

    @Override
    public T create(T t) {
        return mediaRepo.create(t);
    }

    @Override
    public boolean update(T t) {
        return mediaRepo.update(t);
    }

    @Override
    public boolean delete(int id) {
        return mediaRepo.delete(id);
    }

    @Override
    public L findByCategory(Category category) {
        return mediaRepo.findByCategory(category);
    }

    @Override
    public T findByUrl(String url) {
        return mediaRepo.findByUrl(url);
    }

}
