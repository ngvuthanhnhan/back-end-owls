package theowls.api.model.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theowls.api.model.entities.Book;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findAllBySubjectId(String subjectId);
}
