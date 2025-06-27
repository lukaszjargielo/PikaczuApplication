package pl.futurejava.pikaczu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.futurejava.pikaczu.model.Author;
import pl.futurejava.pikaczu.model.Book;

@Configuration
public class ApplicationConfig {

@Bean
    public Author author() {
    return new Author();
}

@Bean
    public Book book() {
    return new Book();
}
}
