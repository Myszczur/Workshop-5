package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService {
    private List<Book> books;
    private static Long nextId = 4L;

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
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(it -> id.equals(it.getId()))
                .findFirst();
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void delBook(Long id) {
        if (getBookById(id).isPresent()) {
            books.remove(this.getBookById(id).get());
        }
    }

    @Override
    public void editBook(Book book) {
        if (this.getBookById(book.getId()).isPresent()) {
            books.set(books.indexOf(this.getBookById(book.getId()).get()), book);
        }
    }
}
