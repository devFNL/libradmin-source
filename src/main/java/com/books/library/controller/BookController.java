package com.books.library.controller;

import com.books.library.entity.Book;
import com.books.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookList")
    public String showAllBooks(Model model) {
        try {
            List<Book> books = bookService.getAllBooks();
            model.addAttribute("frontendBooks", books);
            return "books";
        } catch (Exception e) {
            return "Error. " + e.getMessage();
        }
    }

    @GetMapping("/newBook")
    public String showRegistrationForm(Model model) {
        model.addAttribute("book", new Book());
        return "newBook";
    }

    @PostMapping("/newBook")
    public String registerBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/newBook";
    }

    @PostMapping("/editBook")
    public String editUser(@ModelAttribute Book book) {
        bookService.editBookById(book.getId(), book);
        return "redirect:/bookList";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam long id) {
        bookService.deleteBookById(id);
        return "redirect:/bookList";
    }

}