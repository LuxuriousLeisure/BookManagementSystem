import java.util.*;

public class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Library library, String isbn) {
        if (library.borrowBook(isbn)) {
            borrowedBooks.add(library.findBookByIsbn(isbn));
            System.out.println(name + " successfully borrowed the book.");
        } else {
            System.out.println("Sorry, the book is unavailable.");
        }
    }

    public void returnBook(Library library, String isbn) {
        if (library.returnBook(isbn)) {
            borrowedBooks.removeIf(book -> book.getIsbn().equals(isbn));
            System.out.println(name + " successfully returned the book.");
        } else {
            System.out.println("This book wasn't borrowed from this library.");
        }
    }

    public void printBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no borrowed books.");
        } else {
            System.out.println(name + "'s borrowed books:");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }
}
