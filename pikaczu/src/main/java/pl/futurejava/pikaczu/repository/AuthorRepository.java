package pl.futurejava.pikaczu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.futurejava.pikaczu.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
