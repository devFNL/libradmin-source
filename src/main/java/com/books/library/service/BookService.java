package com.books.library.service;

import com.books.library.entity.Book;
import com.books.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book editBookById(long id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found."));

        existingBook.setISBN(book.getISBN());
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setRelease_year(book.getRelease_year());
        existingBook.setCopies(book.getCopies());
        existingBook.setCopies_borrowed(book.getCopies_borrowed());
        existingBook.setCopies_remaining(book.getCopies_remaining());
        existingBook.setIs_active(book.isIs_active());

        return bookRepository.save(existingBook);
    }

    public void deleteBookById(long id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found."));

        bookRepository.delete(existingBook);
    }

}
