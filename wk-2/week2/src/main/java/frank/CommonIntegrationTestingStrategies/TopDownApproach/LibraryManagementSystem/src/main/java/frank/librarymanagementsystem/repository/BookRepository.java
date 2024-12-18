package frank.librarymanagementsystem.repository;

import frank.librarymanagementsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByTitleContainingIgnoreCase(String keyword);
}