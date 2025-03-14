package com.kev.springrest.service;


import com.kev.springrest.dto.BookDTO;
import com.kev.springrest.exception.*;
import com.kev.springrest.model.Book;
import com.kev.springrest.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


@Data
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDTOWrapper bookDTOWrapper;

    public Iterable<Book> findAll() {
        if (bookRepository.count() == 0) {
            throw new BooksNotFoundException();
        }
        return bookRepository.findAll();
    }

    public Optional<Book> findById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book;
        }
        throw new BookNotFoundException(id);
    }

    public void saveBook(final Book book) {
        Iterable<Book>  books= bookRepository.findAll();

        if (book.getTitle() == null || book.getTitle().isEmpty() || book.getPublicationDate() == null || book.getDescription() == null || book.getDescription().isEmpty()) {
            throw new SaveBookBadRequestException(book.getTitle());
        }

        for (Book b : books) {
            if (Objects.equals(b.getTitle(), book.getTitle())){
                throw new SaveBookExistsException(book.getTitle(), book.getId());
            }
        }

        bookRepository.save(book);
    }

    public void updateBook(long id, final Book book) {
        Optional<Book> prevBook = bookRepository.findById(id);

        if (prevBook.isEmpty()) {
            throw new UpdateBookNotFoundException(book.getTitle(), book.getId());
        }

        Book oldBook = prevBook.get();
        oldBook.setTitle(book.getTitle());
        oldBook.setDescription(book.getDescription());
        oldBook.setPublicationDate(book.getPublicationDate());

        bookRepository.save(oldBook);
    }

    public void deleteBook(final long id) {
        if (bookRepository.findById(id).isEmpty()){
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

    public BookDTO getBookDTO(final Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            throw new BookNotFoundException(id);
        }

        return bookRepository.findById(id).stream()
                .map(BookDTOWrapper::toDTO).findFirst().orElse(null);
    }

    public ArrayList<BookDTO> findAllDTO() {
        if (bookRepository.count() == 0) {
            throw new BooksNotFoundException();
        }

        Iterable<Book> books = bookRepository.findAll();

        ArrayList<BookDTO> bookDTOs = new ArrayList<>();

        for (Book b : books) {
            bookDTOs.add(BookDTOWrapper.toDTO(b));
        }

        if (bookDTOs.isEmpty()) {
            throw new BooksNotFoundException();
        }

        return bookDTOs;
    }

}
