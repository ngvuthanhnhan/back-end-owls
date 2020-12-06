package theowls.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theowls.api.model.entities.Book;
import theowls.api.model.repository.BookRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping
    List<Book> GetAllBook() {
        return bookRepo.findAll();
    }

    @PostMapping
    Book CreateBook(@RequestBody Book newBook) {
        return bookRepo.save(newBook);
    }

    @GetMapping("/{SubjectId}")
    List<Book> GetAllBookBySubjectId(@PathVariable("SubjectId") String SubjectId) {
        return bookRepo.findAllBySubjectId(SubjectId);
    }

    @PutMapping("/{Id}")
    Book EditBook(
            @RequestBody Book newBook,
            @PathVariable("Id") Long Id
    ) {
        return bookRepo.findById(Id)
            .map(book -> {
                book.setSubjectId(newBook.getSubjectId());
                book.setName(newBook.getName());
                book.setDescription(newBook.getDescription());
                book.setInfo(newBook.getInfo());
                return bookRepo.save(book);
            })
            .orElseGet(() -> {
                newBook.setId(Id);
                return bookRepo.save(newBook);
            });
    }

    @DeleteMapping("/{Id}")
    void DeleteBookById(@PathVariable("Id") Long Id) {
        bookRepo.deleteById(Id);
    }

}
