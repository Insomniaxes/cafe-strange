package be.cafe_strange.implementations.services.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.interfaces.repositories.media.MediaRepo;
import be.cafe_strange.interfaces.services.media.MediaService;
import be.cafe_strange.models.extra.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Service
@Transactional
public abstract class MediaServiceImpl<T, L> implements MediaService<T, L> {

    @Autowired
    MediaRepo<T,L> mediaRepo;

    @Override
    public L findByNewsId(int id, MediaType mediaType) {
        return mediaRepo.findByNewsId(id, mediaType);
    }

}
