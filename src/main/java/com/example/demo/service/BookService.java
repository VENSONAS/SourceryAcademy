package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BookEntity> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public BookEntity saveBook(BookEntity book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public List<BookEntity> getBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<BookEntity> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorContaining(author);
    }

    public List<BookEntity> getBooksByYear(int year) {
        return bookRepository.findByYear(year);
    }

    public List<BookEntity> getBooksByRating(double minRating, double maxRating) {
        return bookRepository.findByRatingBetween(minRating, maxRating);
    }
}