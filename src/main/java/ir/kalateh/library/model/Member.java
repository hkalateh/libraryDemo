package ir.kalateh.library.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String family;
    private String nationalCode;
    private int age;
    
    @ManyToMany
    @JoinTable(name = "borrow_table", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> boooks = new HashSet<>();
}
