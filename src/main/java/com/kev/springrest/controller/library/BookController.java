package com.kev.springrest.controller.library;

import com.kev.springrest.dto.BookDTO;
import com.kev.springrest.model.Book;
import com.kev.springrest.service.library.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Iterable<Book> FindAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> FindSingleBook(@PathVariable long id) {
        return bookService.findById(id);
    }

    @PostMapping("/book")
    public Book AddBook(@RequestBody @Valid Book book) {
        bookService.saveBook(book);
        return book;
    }

    @PutMapping("/book/{id}")
    public Book UpdateBook(@PathVariable long id, @RequestBody Book book) {
        bookService.updateBook(id,book);
        return book;
    }

    @DeleteMapping("/book/{id}")
    public String DeleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "Le livre a été supprimé avec succès !";
    }

    @GetMapping("/book-dto/{id}")
    public BookDTO GetBookDTO(@PathVariable long id) {
        return bookService.getBookDTO(id);
    }

    @GetMapping("/book-dtos")
    public Iterable<BookDTO> GetBookDTOs() {
        return bookService.findAllDTO();
    }


}