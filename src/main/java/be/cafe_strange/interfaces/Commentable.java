package be.cafe_strange.interfaces;

import be.cafe_strange.models.Comment;

public interface Commentable {

    Comment addComment(Comment comment);

    void removeComment(Comment comment);

}
