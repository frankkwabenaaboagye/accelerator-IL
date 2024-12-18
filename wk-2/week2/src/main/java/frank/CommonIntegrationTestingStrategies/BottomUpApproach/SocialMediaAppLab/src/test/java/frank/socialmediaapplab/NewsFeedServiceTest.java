package frank.socialmediaapplab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

public class NewsFeedServiceTest {

    @Mock
    private NewsFeedRepository newsFeedRepository;

    @InjectMocks
    private NewsFeedService newsFeedService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testGetNewsFeed() {
        NewsFeed mockPost = new NewsFeed();
        mockPost.setId(1L);
        mockPost.setUserId(1L);
        mockPost.setPostContent("Hello, world!");

        when(newsFeedRepository.findByUserId(1L)).thenReturn(List.of(mockPost));

        List<NewsFeed> posts = newsFeedService.getNewsFeed(1L);
        assertFalse(posts.isEmpty());
        assertEquals("Hello, world!", posts.get(0).getPostContent());
    }
}