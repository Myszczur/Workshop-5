package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements BookService {
    private List<Book> books;
    private static Long nextId = 3L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public List<Book> getBookById(Long id) {
        List<Book> bookId = new ArrayList<>();
        return bookId = books.stream()
                .filter(it -> id.equals(it.getId()))
                .toList();
    }

    @Override
    public void addBook(Book book) {
        book.setId(++nextId);
        books.add(book);
    }


}
