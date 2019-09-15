package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "borrow")

public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_borrow")
    private int idBorrow;

    @ManyToOne
    @JoinColumn (name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn (name = "borrower_id")
    private Borrower borrower;

    @Column(name = "rental_date")
    private Date rentalDate;

}
