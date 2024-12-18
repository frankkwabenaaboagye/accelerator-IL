package frank.librarymanagementsystem.controllers;

import frank.librarymanagementsystem.models.Book;
import frank.librarymanagementsystem.services.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService; // Use @MockBean to register the mock with Spring

    @Test
    void testSearchBooks() throws Exception {
        // Mock the behavior of the BookService
        Mockito.when(bookService.searchBooks("java"))
                .thenReturn(List.of(new Book("2", "Effective Java", "Joshua Bloch")));

        // Perform the GET request and verify the response
        mockMvc.perform(get("/books/search").param("keyword", "java"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Effective Java"));
    }
}