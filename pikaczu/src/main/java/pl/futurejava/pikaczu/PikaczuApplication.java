package pl.futurejava.pikaczu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.futurejava.pikaczu.model.Author;
import pl.futurejava.pikaczu.model.Book;
import pl.futurejava.pikaczu.repository.AuthorRepository;
import pl.futurejava.pikaczu.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PikaczuApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(PikaczuApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			var bies = Author.builder()
					.firstName("Syliwa")
					.lastName("Bies")
					.build();

			var jargielo = Author.builder()
					.firstName("Natalia")
					.lastName("Jargieło")
					.build();

			var janta = Author.builder()
					.firstName("Mateusz")
					.lastName("Jańta")
					.build();

			var mokradla = Book.builder()
					.title("Mokradła")
					.ean("9788367334969")
					.build();

			var przemcio_nad_morzem = Book.builder()
					.title("A guzik z pętelką! Nad morzem")
					.ean("9788367334938")
					.build();

			var po_drodze_donikad = Book.builder()
					.title("Po drodze donikąd")
					.ean("9788368293173")
					.build();

			mokradla.setAuthors(List.of(bies));
			przemcio_nad_morzem.setAuthors(List.of(bies,jargielo));
			po_drodze_donikad.setAuthors(List.of(janta));

			bies.setBooks(List.of(mokradla, przemcio_nad_morzem));
			jargielo.setBooks(List.of(przemcio_nad_morzem));
			janta.setBooks(List.of(po_drodze_donikad));

			bookRepository.saveAll(List.of(mokradla, przemcio_nad_morzem, po_drodze_donikad));
		};
	}
}
