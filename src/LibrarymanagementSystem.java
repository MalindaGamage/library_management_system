import repository.FileLibraryRepository;
import repository.LibraryException;
import service.LibraryService;

import java.util.Scanner;
import java.util.logging.Logger;

public class LibrarymanagementSystem {

    private static final Logger LOGGER = Logger.getLogger(LibraryService.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static LibraryService libraryService;

    public static void main(String[] args) {
        libraryService = new LibraryService(new FileLibraryRepository());
        while (true) {
            displayMenu();
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addBook();
                    case 2:
                        // Add Borrower logic
                        break;
                    case 3:
                        // Borrow Book logic
                        break;
                    case 4:
                        // Return Book logic
                        break;
                    case 5:
                        // List Books logic
                        break;
                    case 6:
                        // List Borrowers logic
                        break;
                    case 7:
                        // List Loans logic
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

    }

    private static void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Add Borrower");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. List Books");
        System.out.println("6. List Borrowers");
        System.out.println("7. List Loans");
        System.out.println("8. Exit");
        System.out.print("Enter choice: ");
    }

    private static  void addBook() throws LibraryException {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        libraryService.addBook(isbn, title, author);
        System.out.println("Book added successfully.");
    }
}