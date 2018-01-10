package be.cafe_strange.interfaces.services;

import be.cafe_strange.models.ForumPost;
import be.cafe_strange.interfaces.MainInterface;

import java.util.List;

public interface ForumPostService extends MainInterface<ForumPost, List<ForumPost>> {

    List<ForumPost> findByUsername(String username);

}
