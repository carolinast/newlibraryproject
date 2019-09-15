package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "borrower")

public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_borrower")
    private int idBorrower;

    @Column(name = "firs_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "borrower_details")
    private int borrowerDetails;

    @OneToMany(mappedBy = "borrower")
    private List<Borrow> borrowList;

    public String borrowerFullName() {
        return firstName + " " + lastName;
    }
}
