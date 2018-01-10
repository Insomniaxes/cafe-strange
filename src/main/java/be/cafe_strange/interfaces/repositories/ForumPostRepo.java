package be.cafe_strange.interfaces.repositories;

import be.cafe_strange.models.ForumPost;
import be.cafe_strange.interfaces.MainInterface;

import java.util.List;

public interface ForumPostRepo extends MainInterface<ForumPost, List<ForumPost>>{

    List<ForumPost> findByUsername(String username);

}
