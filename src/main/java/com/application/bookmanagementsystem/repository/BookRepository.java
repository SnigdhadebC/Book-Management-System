package com.application.bookmanagementsystem.repository;

import com.application.bookmanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select u from Book u where lower(u.title) = lower(?1)")
    Optional<Book> findAllByTitle(String title);
}
