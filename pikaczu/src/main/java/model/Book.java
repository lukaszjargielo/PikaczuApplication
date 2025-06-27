package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns =
            @JoinColumn(name = "book_id"),
            inverseJoinColumns =
            @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    private String ean;
}
