package be.cafe_strange.interfaces.services.interactive;

import be.cafe_strange.models.forum.ForumPost;
import be.cafe_strange.interfaces.main.MainInterface;
import be.cafe_strange.models.forum.ForumPost;

import java.util.List;

public interface ForumPostService extends MainInterface<ForumPost, List<ForumPost>> {

    List<ForumPost> findByUsername(String username);

}
