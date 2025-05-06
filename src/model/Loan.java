package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Loan implements Serializable {
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;

    public Loan(Book book, Borrower borrower, LocalDate borrowDate) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }
    public Borrower getBorrower() {
        return borrower;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book +
                ", borrower=" + borrower +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
