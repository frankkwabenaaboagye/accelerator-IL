package frank.librarymanagementsystem.controllers;

import frank.librarymanagementsystem.models.MyUser;
import frank.librarymanagementsystem.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyUserController.class)
public class MyUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testListUsers() throws Exception {
        Mockito.when(userService.getUsers())
                .thenReturn(Arrays.asList(new  MyUser("1", "Alice", "alice@a.com"), new MyUser("2", "Bob", "bob@b.com")));

        mockMvc.perform(get("/users/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }
}