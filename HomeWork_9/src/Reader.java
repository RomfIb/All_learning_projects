public class Reader {
    private String name;
    private int ticketNumber;
    private Book[] borrowedBooks;
    private int borrowedCount;

    public Reader(String name, int ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
        this.borrowedBooks = new Book[3];
        this.borrowedCount = 0;
    }

    public String getName() { return name; }

    public boolean canBorrow() {
        return borrowedCount < borrowedBooks.length;
    }

    public void takeBook(Book book) {
        if (canBorrow()) {
            borrowedBooks[borrowedCount] = book;
            borrowedCount++;
        }
        else
            System.out.println("Cannot borrow more books");
    }

    public void giveBackBook(Book book) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] == book) {
                for (int j = i; j < borrowedCount - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                }
                borrowedBooks[borrowedCount - 1] = null;
                borrowedCount--;
                break;
            }
        }
    }

    public void printBorrowedBooks() {
        System.out.println("Books " + name + " has now: ");
        if (borrowedCount == 0) {
            System.out.println("No books");
            return;
        }
        for (int i = 0; i < borrowedCount; i++) {
            System.out.println(borrowedBooks[i].getTitle());
            if (i < borrowedCount - 1)
                System.out.println(",\n");
        }
    }
}
