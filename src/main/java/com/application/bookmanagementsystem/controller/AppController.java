package com.application.bookmanagementsystem.controller;

import com.application.bookmanagementsystem.model.Book;
import com.application.bookmanagementsystem.model.Review;
import com.application.bookmanagementsystem.repository.BookRepository;
import com.application.bookmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class AppController {

    @Autowired
    private BookService bookService;

    private int count = 0;

    @GetMapping("/title/{titleName}")
    public Book getBookDetailsByTitle(@PathVariable("titleName") String title){
        count ++ ;
        System.out.println("Count : "+count);
        if(count == 1){
            bookService.registerData();
        }
        return bookService.findBookByTitle(title).orElse(null);
    }
}
