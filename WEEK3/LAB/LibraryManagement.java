class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int bookCounter = 1;

    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    // Static method to generate unique book ID
    public static String generateBookId() {
        return String.format("B%03d", bookCounter++);
    }

    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println("Book ID       : " + bookId);
        System.out.println("Title         : " + title);
        System.out.println("Author        : " + author);
        System.out.println("Available     : " + (isAvailable ? "Yes" : "No"));
        System.out.println("-------------------------------------");
    }

    public String getBookId() {
        return bookId;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }

    public static int getAvailableBooks() {
        return availableBooks;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        // Create array of exactly 3 books
        Book[] books = new Book[3];
        books[0] = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        books[1] = new Book("1984", "George Orwell");
        books[2] = new Book("To Kill a Mockingbird", "Harper Lee");

        // Display all 3 books info
        System.out.println("Books in Library:");
        for (Book book : books) {
            book.displayBookInfo();
        }

        // Example transactions: issue and return for demonstration
        System.out.println("Issuing book B001 and B003...");
        if (books[0].issueBook()) {
            System.out.println("Book " + books[0].getBookId() + " issued successfully.");
        }
        if (books[2].issueBook()) {
            System.out.println("Book " + books[2].getBookId() + " issued successfully.");
        }

        System.out.println("\nBooks availability after issuing:");
        for (Book book : books) {
            book.displayBookInfo();
        }

        System.out.println("Returning book B001...");
        books[0].returnBook();

        System.out.println("\nBooks availability after return:");
        for (Book book : books) {
            book.displayBookInfo();
        }

        // Display library statistics
        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
    }
}
