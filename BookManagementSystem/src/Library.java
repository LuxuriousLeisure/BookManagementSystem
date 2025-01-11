import java.io.*;
import java.util.*;

public class Library {
    private static final String BOOKS_FILE = "data/books.txt";
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
        loadBooksFromFile();
    }

    // 从文件中加载书籍
    private void loadBooksFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading books from file.");
        }
    }

    // 更新书籍信息到文件
    private void saveBooksToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books to file.");
        }
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        saveBooksToFile();
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null && book.getStock() > 0) {
            book.setStock(book.getStock() - 1);
            saveBooksToFile();
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            book.setStock(book.getStock() + 1);
            saveBooksToFile();
            return true;
        }
        return false;
    }

    public void printLibrary() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
