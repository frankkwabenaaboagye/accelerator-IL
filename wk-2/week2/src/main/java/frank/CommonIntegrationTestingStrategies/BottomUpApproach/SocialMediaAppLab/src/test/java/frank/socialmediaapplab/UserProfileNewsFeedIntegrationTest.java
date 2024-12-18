package frank.socialmediaapplab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = SocialMediaAppLabApplication.class)
public class UserProfileNewsFeedIntegrationTest {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private NewsFeedService newsFeedService;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private NewsFeedRepository newsFeedRepository;

    @BeforeEach
    public void setUp() {
        UserProfile profile = new UserProfile();
        profile.setId(1L);
        profile.setUsername("john_doe");
        profile.setEmail("john.doe@example.com");
        userProfileRepository.save(profile);

        NewsFeed post = new NewsFeed();
        post.setId(1L);
        post.setUserId(profile.getId());
        post.setPostContent("This is a test post.");
        newsFeedRepository.save(post);
    }

    @Test
    public void testUserProfileWithNewsFeed() {
        UserProfile profile = userProfileService.getUserProfile("john_doe");
        assertNotNull(profile);

        List<NewsFeed> posts = newsFeedService.getNewsFeed(profile.getId());
        assertFalse(posts.isEmpty());
    }
}