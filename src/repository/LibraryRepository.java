package repository;

import model.Book;

import java.util.List;

public interface LibraryRepository {
    void saveBook(List<Book> books) throws LibraryException;
    List<Book> loadBooks() throws LibraryException;
//    void saveBorrower(List<Borrower> borrowers) throws LibraryException;
//    List<Borrower> loadBorrowers() throws LibraryException;
}
