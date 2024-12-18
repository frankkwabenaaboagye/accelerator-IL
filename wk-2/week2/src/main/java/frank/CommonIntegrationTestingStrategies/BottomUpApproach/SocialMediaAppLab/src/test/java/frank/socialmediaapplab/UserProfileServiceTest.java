package frank.socialmediaapplab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserProfileServiceTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileService userProfileService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }


    @Test
    public void testGetUserProfile() {
        UserProfile mockProfile = new UserProfile();
        mockProfile.setId(1L);
        mockProfile.setUsername("john_doe");

        when(userProfileRepository.findByUsername("john_doe")).thenReturn(mockProfile);

        UserProfile profile = userProfileService.getUserProfile("john_doe");
        assertEquals("john_doe", profile.getUsername());
    }
}