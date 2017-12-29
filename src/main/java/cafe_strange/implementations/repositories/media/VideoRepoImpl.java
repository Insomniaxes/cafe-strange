package cafe_strange.implementations.repositories.media;

import cafe_strange.interfaces.repositories.media.VideoRepo;
import cafe_strange.models.media.Video;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VideoRepoImpl extends MediaRepoImpl<Video, List<Video>> implements VideoRepo {
}
