package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_author")
    private long idAuthor;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_place")
    private String birthPlace;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public String authorFullName() {
        return firstName + " " + lastName;
    }
}
