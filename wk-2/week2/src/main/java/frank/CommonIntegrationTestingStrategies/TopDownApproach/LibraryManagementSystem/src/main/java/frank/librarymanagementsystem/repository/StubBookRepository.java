package frank.librarymanagementsystem.repository;

import frank.librarymanagementsystem.models.Book;

import java.util.ArrayList;
import java.util.List;

public class StubBookRepository {
    private List<Book> books = new ArrayList<>();

    public StubBookRepository() {
        books.add(new Book("1", "Spring Boot in Action", "Craig Walls"));
        books.add(new Book("2", "Effective Java", "Joshua Bloch"));
    }

    public List<Book> findByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}