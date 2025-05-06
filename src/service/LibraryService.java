package service;

import model.Book;
import repository.LibraryException;
import repository.LibraryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    // private List<Borrower> borrowers = new ArrayList<>();
    // private List<Loan> loans = new ArrayList<>();

    private final LibraryRepository repository;
    private static final Logger LOGGER = Logger.getLogger(LibraryService.class.getName());

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
        loadData();
    }

    private void loadData() {
        try {
            books = repository.loadBooks();
            // borrowers = repository.loadBorrowers();
        } catch (LibraryException e) {
            LOGGER.severe("Error loading data: " + e.getMessage());
        }
    }

    public void addBook(String isbn, String title, String author) throws LibraryException {
        if (isbn == null || title == null || author == null) {
            throw new LibraryException("Book details cannot be null");
        }
        books.add(new Book(isbn, title, author));
        repository.saveBook(books);
        LOGGER.info("Book added: " + title);
    }
}
