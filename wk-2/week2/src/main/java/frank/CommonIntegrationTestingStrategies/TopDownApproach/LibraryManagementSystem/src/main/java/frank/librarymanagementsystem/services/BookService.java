package frank.librarymanagementsystem.services;

import frank.librarymanagementsystem.models.Book;
import frank.librarymanagementsystem.repository.BookRepository;
import frank.librarymanagementsystem.repository.StubBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    /*
    private final StubBookRepository bookRepository = new StubBookRepository();

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitle(keyword);
    }*/

    private final BookRepository bookRepository;

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

}