package be.cafe_strange.interfaces;

import be.cafe_strange.models.Comment;

public interface Commentable {

    void addComment(Comment comment);

    void removeComment(Comment comment);

}
