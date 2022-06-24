package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    List<Book> getBookById(Long id);
    void addBook(Book book);

}
