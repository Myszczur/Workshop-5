package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    Optional<Book> getBookById(Long id);
    void addBook(Book book);
    void delBook(Long id);
    void editBook(Book book);

}
