package ir.kalateh.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "first_name", columnDefinition = "nvarchar2", length = 30)
    @EqualsAndHashCode.Exclude
    private String firstName;
    @EqualsAndHashCode.Exclude
    private String lastName;
    private String nationalCode;
    @ManyToMany(mappedBy = "authors")
    @EqualsAndHashCode.Exclude
    private Set<Book> books = new HashSet<>();
    
    public Author(String firstName, String lastName, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }
}
