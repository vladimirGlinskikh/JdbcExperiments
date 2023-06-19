package kz.zhelezyaka.jdbcexperiments.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private String publisher;

    @Transient
    private Author authorId;

    public Author getAuthor(){
        return authorId;
    }

    public void setAuthor(Author authorId) {
        this.authorId = authorId;
    }
}