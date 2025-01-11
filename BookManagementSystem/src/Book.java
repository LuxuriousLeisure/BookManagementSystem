public class Book {
    private String title;
    private String author;
    private String isbn;
    private int stock;

    public Book(String title, String author, String isbn, int stock) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return title + "," + author + "," + isbn + "," + stock;
    }

    // 从字符串读取书籍信息
    public static Book fromString(String line) {
        String[] parts = line.split(",");
        return new Book(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
    }
}
