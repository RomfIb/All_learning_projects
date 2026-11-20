public class Book {
    private String title;
    private String author;
    private int year;
    private Reader borrower;

    public Book (){

    }
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrower = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Reader getBorrower() {
        return borrower;
    }

    public void setBorrower(Reader borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return title + " " + author + " " + year +
                (borrower != null ? " borowed by " + borrower.getName() : " no borrower");
    }
}
