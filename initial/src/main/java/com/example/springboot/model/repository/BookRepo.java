package com.example.springboot.model.repository;

import com.example.springboot.model.entities.Book;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepositories<Book, Integer> {

    Object findAllBook();
}
