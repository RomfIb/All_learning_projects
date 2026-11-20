import Exception.BookAlreadyBorrowedException;
import Exception.BookNotFoundException;
import Exception.ReaderBookLimitException;
public class Library {
    private Book[] books = new Book[10];
    private int bookCount = 0;

    public int getBookCount() {
        return bookCount;
    }

    public int getMaxCapacity() {
        return books.length;
    }

    public void addBook(String title, String author, int year) {
        if (bookCount >= books.length) {
            System.out.println("Library is full!");
            return;
        }
        books[bookCount] = new Book(title, author ,year);
        bookCount++;
        System.out.println("Book " + title + " is added!");
    }

    public void showBooks() {
        if (bookCount == 0) {
            System.out.println("Library is empty");
            return;
        }
        System.out.println("Library consists of: ");
        for (int i = 0; i < bookCount; i++) {
            System.out.println((i + 1) + ": " + books[i]);
        }
    }

    public void borrowBook(String title, Reader borrower) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                if (books[i].getBorrower() != null) {
//                    System.out.println(title + " has been already borrowed by "
//                            + books[i].getBorrower().getName());
//                    return;
                    throw new BookAlreadyBorrowedException("Book " + title + " is already borrowed by " +
                            books[i].getBorrower().getName());
                }

                if (!borrower.canBorrow()) {
//                    System.out.println(borrower.getName() + " cannot borrow any more books");
//                    return;
                    throw new ReaderBookLimitException("Reader " + borrower + " cannot borrow more books!");
                }

                books[i].setBorrower(borrower);
                borrower.takeBook(books[i]);
                System.out.println("Book " + books[i].getTitle() + " is given to " + borrower.getName());
                return;
            }
        }
//        System.out.println("Book " + title + " is not found!");
        throw new BookNotFoundException("Book " + title + " is not found in library!");
    }

    public void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                Reader borrower = books[i].getBorrower();
                if (books[i].getBorrower() == null) {
                    System.out.println("Book is already in the library");
                    return;
                }
                borrower.giveBackBook(books[i]);
                books[i].setBorrower(null);
                System.out.println("Book " + books[i].getTitle() + " is returned to the library");
                return;
            }
        }
        System.out.println("Book " + title + " is not found");
    }

    public void removeBook(String title) {
        int targetIndex = -1;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex != -1) {
            for (int i = targetIndex; i < bookCount - 1; i++) {
                books[i] = books[i+1];
            }
            books[bookCount-1] = null;
            bookCount--;
            System.out.println("Book " + title + " is removed");
        }
        else
            System.out.println("Book " + title + " is not found");
    }

    public void findByAuthor(String author) {
        boolean found = false;
        System.out.println("This author's books are: ");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found)
            System.out.println("This author's books are not found");
    }

}