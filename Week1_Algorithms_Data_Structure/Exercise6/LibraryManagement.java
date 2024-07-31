
import java.util.Arrays;
import java.util.List;

class Book {

    private final int bookId;
    private final String title;
    private final String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{"
                + "bookId=" + bookId
                + ", title='" + title + '\''
                + ", author='" + author + '\''
                + '}';
    }
}

public class LibraryManagement {

    // Linear Search Function
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search Function
    public static Book binarySearch(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Creating a list of books
        List<Book> books = Arrays.asList(
                new Book(1, "The Alchemist", "Paulo Coelho"),
                new Book(2, "The Hobbit", "J.R.R. Tolkien"),
                new Book(3, "Moby Dick", "Herman Melville"),
                new Book(4, "War and Peace", "Leo Tolstoy"),
                new Book(5, "Ulysses", "James Joyce")
        );

        // Search for a book by title
        String searchTitle = "War and Peace";

        // Linear search example
        Book resultLinear = linearSearch(books, searchTitle);
        System.out.println("Linear Search Result: " + resultLinear);

        // Sorting books by title for binary search
        books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        Book resultBinary = binarySearch(books, searchTitle);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}

// OUTPUT
// Linear Search Result: Book{bookId=4, title='War and Peace', author='Leo Tolstoy'}
// Binary Search Result: Book{bookId=4, title='War and Peace', author='Leo Tolstoy'}
