import java.util.Scanner;
import Exception.BookAlreadyBorrowedException;
import Exception.BookNotFoundException;
import Exception.ReaderBookLimitException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Reader[] readers = {
                new Reader("Mark", 123),
                new Reader("Alex", 124),
                new Reader("Jane", 125)
        };

        library.addBook("Преступление и наказание","Федор Достоевский", 1866);
        library.addBook("Евгений Онегин", "Александр Пушкин", 1833);
        library.addBook("Война и Мир", "Лев Толстой", 1869);

        while (true) {
            System.out.println("\nLibrary has " + library.getBookCount() + " of "
                    + library.getMaxCapacity() + " books\n");
            System.out.println("-------------Choose option:----------");
            System.out.println("======== 1: Show all books =======");
            System.out.println("===== 2: Give book to a reader ====");
            System.out.println("==== 3: Return book to the library ====");
            System.out.println("========== 4: Add new book ========");
            System.out.println("========= 5: Remove book =========");
            System.out.println("======== 6: Find authors's books ======");
            System.out.println("========= 7: Exit =========");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": {
                    library.showBooks();
                    break;
                }

                case "2": {
                    System.out.println("Enter book's title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter reader's name: ");
                    String readerName = scanner.nextLine();
                    Reader foundReader = null;
                    for (Reader r : readers) {
                        if (r.getName().equalsIgnoreCase(readerName)) {
                            foundReader = r;
                            break;
                        }
                    }

                    if (foundReader != null) {
                        try {
                            library.borrowBook(title, foundReader);
                        }
                        catch (BookNotFoundException | BookAlreadyBorrowedException | ReaderBookLimitException e) {
                            System.err.println(e.getMessage());
                        }
//                        library.borrowBook(title, foundReader);
                    }
                    else {
                        System.out.println("Reader with name " + readerName + " is not registered!");
                    }
                    break;
                }
                case "3": {
                    System.out.println("Enter book title you want to return: ");
                    String title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                }
                case "4": {
                    System.out.println("Enter book's title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author's name: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter year of publication");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(title, author, year);
                    break;
                }
                case "5": {
                    System.out.println("Enter book title you want to remove: ");
                    String title = scanner.nextLine();
                    library.removeBook(title);
                    break;
                }
                case "6": {
                    System.out.println("Enter name of author you search: ");
                    String author = scanner.nextLine();
                    library.findByAuthor(author);
                    break;
                }
                case "7": {
                    System.out.println("Good bye!");
                    return;
                }
                default:
                    System.out.println("Wrong number! Try again");
                    break;
            }
        }
    }
}