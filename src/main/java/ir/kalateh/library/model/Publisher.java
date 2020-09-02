package ir.kalateh.library.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Publisher implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private String address;
    
    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "publisher_id")
    @EqualsAndHashCode.Exclude
    private Set<Book> books = new HashSet<>();
    
    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
