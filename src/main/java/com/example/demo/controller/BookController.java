package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // GET: Fetch all books
    @GetMapping("/filter")
    public List<BookEntity> filterBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) Double maxRating) {

        if (title != null) {
            return bookService.getBooksByTitle(title);
        }
        if (author != null) {
            return bookService.getBooksByAuthor(author);
        }
        if (year != null) {
            return bookService.getBooksByYear(year);
        }
        if (minRating != null && maxRating != null) {
            return bookService.getBooksByRating(minRating, maxRating);
        }
        return bookService.getAllBooks();
    }

    // POST: Add a new book
    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        BookEntity savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // DELETE: Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}