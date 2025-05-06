package repository;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileLibraryRepository implements LibraryRepository{
    private static final String BOOKS_FILE = "books.txt";
    private static final String BORROWERS_FILE = "borrowers.txt";
    private static final Logger LOGGER = Logger.getLogger(FileLibraryRepository.class.getName());

    @Override
    public void saveBook(List<Book> books) throws LibraryException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKS_FILE))){
            oos.writeObject(books);
            LOGGER.info("Books saved successfully.");
        }catch (IOException e){
            LOGGER.severe("Error saving books: " + e.getMessage());
            throw new LibraryException("Failed to save book" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> loadBooks() throws LibraryException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKS_FILE))){
            return (List<Book>) ois.readObject();
        }catch (FileNotFoundException e){
            return new ArrayList<>();
        } catch(IOException | ClassNotFoundException e){
            LOGGER.severe("Error loading books: " + e.getMessage());
            throw new LibraryException("Failed to load books: " + e.getMessage());
        }
    }
}
