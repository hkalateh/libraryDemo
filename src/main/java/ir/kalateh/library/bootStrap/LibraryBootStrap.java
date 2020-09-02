package ir.kalateh.library.bootStrap;

import ir.kalateh.library.model.Author;
import ir.kalateh.library.model.Book;
import ir.kalateh.library.model.Publisher;
import ir.kalateh.library.repository.AuthorRepository;
import ir.kalateh.library.repository.BookRepository;
import ir.kalateh.library.repository.MemberRepository;
import ir.kalateh.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LibraryBootStrap implements CommandLineRunner {
    
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final MemberRepository memberRepository;
    private final PublisherRepository publisherRepository;
    
    @Autowired
    public LibraryBootStrap(BookRepository bookRepository, AuthorRepository authorRepository, MemberRepository memberRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.memberRepository = memberRepository;
        this.publisherRepository = publisherRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        
        Author hossein = new Author("hossein","kalateh","0016701771");
        Book spring = new Book("spring and spring boot","1111");
        
        hossein.getBooks().add(spring);
        spring.getAuthors().add(hossein);
        
        authorRepository.save(hossein);
        bookRepository.save(spring);
        
        
        Publisher publisher = new Publisher("eshragh","tehran");
        
        spring.setPublisher(publisher);
        publisher.getBooks().add(spring);
        publisherRepository.save(publisher);
        bookRepository.save(spring);
        
        System.out.println("Number of Authors ==> " + authorRepository.count());
        System.out.println("Number of Books ==> " + bookRepository.count());
        System.out.println("Number of Members ==> " + memberRepository.count());
        System.out.println("Number of Publishers ==> " + publisherRepository.count());
    }
}
