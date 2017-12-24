package cafe_strange.interfaces.services;

import cafe_strange.interfaces.main.MainInterface;
import cafe_strange.models.forum.ForumPost;

import java.util.List;

public interface ForumPostService extends MainInterface<ForumPost, List<ForumPost>> {

    List<ForumPost> findByUsername(String username);

}
