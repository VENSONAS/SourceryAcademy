package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByTitleContaining(String title);
    List<BookEntity> findByAuthorContaining(String author);
    List<BookEntity> findByYear(int year);
    List<BookEntity> findByRatingBetween(double minRating, double maxRating);
}