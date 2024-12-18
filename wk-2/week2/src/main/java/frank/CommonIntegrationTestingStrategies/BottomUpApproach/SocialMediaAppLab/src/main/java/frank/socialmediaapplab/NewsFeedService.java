package frank.socialmediaapplab;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsFeedService {

    @Autowired
    private NewsFeedRepository newsFeedRepository;

    public List<NewsFeed> getNewsFeed(Long userId) {
        return newsFeedRepository.findByUserId(userId);
    }
}