package ir.kalateh.library.repository;

import ir.kalateh.library.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
