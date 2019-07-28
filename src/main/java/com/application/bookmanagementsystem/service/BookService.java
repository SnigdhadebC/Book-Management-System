package com.application.bookmanagementsystem.service;

import com.application.bookmanagementsystem.model.Book;
import com.application.bookmanagementsystem.model.Review;
import com.application.bookmanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private List<Book> books;

    /**
     *
     */
    public void registerData() {
        books.stream().forEach(u -> {
            List<Review> reviews = u.getReviews();
            reviews.stream().forEach( p -> {
                p.setBook(u);
            });
            u.setReviews(reviews);
            bookRepository.save(u);
        });
    }

    /**
     *
     * @param title
     * @return
     */
    public Optional<Book> findBookByTitle(String title){
       return bookRepository.findAllByTitle(title);
    }
}
