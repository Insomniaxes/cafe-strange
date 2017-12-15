package cafe_strange.models.forum;

import java.util.List;

public class ForumPostList {

    private List<ForumPost> forumPosts;

    public ForumPostList() {
    }

    public ForumPostList(List<ForumPost> forumPosts) {
        this.forumPosts = forumPosts;
    }

    public List<ForumPost> getForumPosts() {
        return forumPosts;
    }

    public void setForumPosts(List<ForumPost> forumPosts) {
        this.forumPosts = forumPosts;
    }
}
