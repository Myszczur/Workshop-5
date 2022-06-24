package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.MockBookService;

import java.util.List;


@RestController
@RequestMapping(value = "/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/helloBook")
    @ResponseBody
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping(value = "")
    @ResponseBody
    public List<Book> getList() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBooksById(@PathVariable Long id) {
        return this.bookService.getBookById(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delBook(@PathVariable Long id) {
        bookService.delBook(id);
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public void editBook(@RequestBody Book book) {
        bookService.editBook(book);
    }
}
