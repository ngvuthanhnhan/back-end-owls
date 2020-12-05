package com.example.springboot.controller;

import com.example.springboot.model.entities.Book;
import com.example.springboot.model.repository.BookRepo;
import com.example.springboot.model.response.BookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/"})
public class BookController {
    private BookRepo bookRepo;

    @GetMapping
    public ResponseEntity<List<BookResponse>> GetAllBook() {
        return new ResponseEntity<Book>(
                bookRepo.findAllBook(),
                HttpStatus.OK
        );
    }

    @GetMapping({"/{BookId}"})
    public ResponseEntity<List<BookResponse>> GetBookBySubjectId() {
        return new ResponseEntity<>(
                bookRepo.findAllBySubjectId(),
                HttpStatus.OK
        );
    }

    @GetMapping({"/{BookName}"})
    public ResponseEntity<List<BookResponse>> GetBookByName() {
        return new ResponseEntity<>(
                bookRepo.findAllByName(),
                HttpStatus.OK
        );
    }
}
