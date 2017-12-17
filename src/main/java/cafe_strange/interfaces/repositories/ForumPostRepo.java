package cafe_strange.interfaces.repositories;

import cafe_strange.models.forum.ForumPost;
import cafe_strange.models.forum.ForumPostList;

public interface ForumPostRepo {

    ForumPost findById(int id);

    ForumPostList findAll();

    ForumPostList findByUsername(String username);

    ForumPost create(ForumPost forumPost);

    void update(ForumPost forumPost);

    void delete(int forumPostId);

}
