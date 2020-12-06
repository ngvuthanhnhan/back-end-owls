package theowls.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theowls.api.model.entities.Book;
import theowls.api.model.repository.BookRepo;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/hemllo")
    String hemllo() {
        return "hemllo";
    }

    @GetMapping
    List<Book> GetAllBook() {
        return bookRepo.findAll();
    }

    @PostMapping
    Book CreateBook(@RequestBody Book newBook) {
        return bookRepo.save(newBook);
    }

    @GetMapping({"/{SubjectId}"})
    List<Book> GetBookById(@PathVariable("SubjectId") String Id) {
        return bookRepo.findAllBySubjectId(Id);
    }

}
