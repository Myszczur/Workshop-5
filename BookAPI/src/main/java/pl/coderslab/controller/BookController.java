package pl.coderslab.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public List<Book> getBooksById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public void addBook(@RequestBody Book book) {
         bookService.addBook(book);
    }
}
