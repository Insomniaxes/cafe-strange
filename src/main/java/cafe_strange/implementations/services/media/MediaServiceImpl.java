package cafe_strange.implementations.services.media;

import cafe_strange.interfaces.repositories.media.MediaRepo;
import cafe_strange.interfaces.services.media.MediaService;
import cafe_strange.models.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepo mediaRepo;

    @Override
    public Media findById(int id) {
        return mediaRepo.findById(id);
    }

    @Override
    public List<Media> findAll() {
        return mediaRepo.findAll();
    }

    @Override
    public Media create(Media media) {
        return mediaRepo.create(media);
    }

    @Override
    public boolean update(Media media) {
        return mediaRepo.update(media);
    }

    @Override
    public boolean delete(int id) {
        return mediaRepo.delete(id);
    }
}
