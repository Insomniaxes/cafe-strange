package cafe_strange.interfaces.services;

import cafe_strange.models.forum.ForumPost;
import cafe_strange.models.forum.ForumPostList;

public interface ForumPostService {

    ForumPost findById(int id);

    ForumPostList findAll();

    ForumPostList findByUsername(String username);

    ForumPost create(ForumPost forumPost);

    void update(ForumPost forumPost);

    void delete(int forumPostId);

}
