package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //here is autoincrement
    @Column(name = "id_book")
    private long idBook;
    @Column(name = "borrow")
    private boolean isBorrowed;
    @Column(name = "category")
    private String category;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "pages")
    private int pages;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "summary")
    private String summary;
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn (name = "author_id")
    private Author author;
    @OneToMany(mappedBy = "book")
    private List<Borrow> borrowList;

    @Transient
    private String borrowerName;


}
