package cafe_strange.implementations.services;

import cafe_strange.interfaces.repositories.ForumPostRepo;
import cafe_strange.interfaces.services.ForumPostService;
import cafe_strange.models.forum.ForumPost;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ForumPostServiceImpl implements ForumPostService {

    @Autowired
    private ForumPostRepo repo;

    @Override
    public ForumPost findById(int id) {
        return repo.findById(id);
    }

    @Override
    public List<ForumPost> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ForumPost> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public ForumPost create(ForumPost forumPost) {
        return repo.create(forumPost);
    }

    @Override
    public boolean update(ForumPost forumPost) {
        return repo.update(forumPost);
    }

    @Override
    public boolean delete(int forumPostId) {
        return repo.delete(forumPostId);
    }

}
