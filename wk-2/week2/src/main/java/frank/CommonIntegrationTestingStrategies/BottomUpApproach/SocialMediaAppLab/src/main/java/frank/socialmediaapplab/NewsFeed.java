package frank.socialmediaapplab;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NewsFeed {
    @Id
    private Long id;
    private Long userId;
    private String postContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }



}