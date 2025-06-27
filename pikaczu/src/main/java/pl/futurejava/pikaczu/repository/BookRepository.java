package pl.futurejava.pikaczu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.futurejava.pikaczu.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
