package cafe_strange.interfaces.services;

import cafe_strange.models.forum.ForumPost;

import java.util.List;

public interface ForumPostService {

    ForumPost findById(int id);

    List<ForumPost> findAll();

    List<ForumPost> findByUsername(String username);

    void create(ForumPost forumPost);

    void update(ForumPost forumPost);

    void delete(int forumPostId);

}
