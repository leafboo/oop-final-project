

public class Book extends Item{
    // attributes
    String title;
    String author;
    String ISBN;
    boolean availabilityStatus;

    public Book(String title, String author, String ISBN, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availabilityStatus = availabilityStatus;
    }

    // methods
    public void checkInBooks() {
        
    }
    public void checkOutBooks() {

    }
}
