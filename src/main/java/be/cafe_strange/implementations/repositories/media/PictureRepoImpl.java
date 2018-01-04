package be.cafe_strange.implementations.repositories.media;

import be.cafe_strange.models.media.Picture;
import be.cafe_strange.interfaces.repositories.media.PictureRepo;
import be.cafe_strange.models.media.Picture;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PictureRepoImpl extends MediaRepoImpl<Picture, List<Picture>> implements PictureRepo{
}
