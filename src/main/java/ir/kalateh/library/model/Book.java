package ir.kalateh.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @EqualsAndHashCode.Exclude
    private String title;
    private String isbn;
    
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
    
    @ManyToMany(mappedBy = "boooks")
    private Set<Member> members = new HashSet<>();
    
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Publisher publisher;
    
    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
