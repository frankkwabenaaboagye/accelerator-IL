package frank.librarymanagementsystem.services;

import frank.librarymanagementsystem.LibraryManagementSystemApplication;
import frank.librarymanagementsystem.models.Book;
import frank.librarymanagementsystem.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LibraryManagementSystemApplication.class)
public class BookServiceIntegrationTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        // Clear existing data before each test
        bookRepository.deleteAll();

        // Insert test data
        bookRepository.save(new Book("1", "Spring Boot in Action", "Craig Walls"));
        bookRepository.save(new Book("2", "Effective Java", "Joshua Bloch"));
    }

    @Test
    void testSearchBooksWithRealDatabase() {
        // Act: Perform a search using the service
        List<Book> books = bookService.searchBooks("java");

        // Assert: Validate the results
        assertEquals(1, books.size());
        assertEquals("Effective Java", books.get(0).getTitle());
    }
}