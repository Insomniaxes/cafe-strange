package be.cafe_strange.implementations.services;

import be.cafe_strange.interfaces.repositories.CommentRepo;
import be.cafe_strange.interfaces.services.CommentService;
import be.cafe_strange.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Override
    public Comment findById(int id) {
        return commentRepo.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepo.create(comment);
    }

    @Override
    public boolean update(Comment comment) {
        return commentRepo.update(comment);
    }

    @Override
    public boolean delete(int id) {
        return commentRepo.delete(id);
    }
}
