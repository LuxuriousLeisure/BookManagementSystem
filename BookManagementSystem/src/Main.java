import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        User user = new User("Alice");

        System.out.println("Welcome to the Library Management System!");
        System.out.print("Are you an Admin or User? (Enter 'admin' or 'user'): ");
        String role = scanner.nextLine().trim().toLowerCase();

        if (role.equals("admin")) {
            // 管理员登录
            System.out.print("Enter Admin Username: ");
            String username = scanner.nextLine().trim();
            System.out.print("Enter Admin Password: ");
            String password = scanner.nextLine().trim();

            if (Admin.login(username, password)) {
                LoadingHelper.simulateLoading();
                System.out.println("Admin login successful!");
                while (true) {
                    System.out.println("\nAdmin Menu:");
                    System.out.println("1. Add Book");
                    System.out.println("2. Remove Book");
                    System.out.println("3. View All Books");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    switch (choice) {
                        case 1:
                            // 添加图书
                            System.out.print("Enter Book Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter Book Author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter Book ISBN: ");
                            String isbn = scanner.nextLine();
                            System.out.print("Enter Book Stock: ");
                            int stock = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            Book newBook = new Book(title, author, isbn, stock);
                            library.addBook(newBook);
                            LoadingHelper.simulateLoading();
                            System.out.println("Book added successfully.");
                            break;

                        case 2:
                            // 删除图书
                            System.out.print("Enter ISBN of the book to remove: ");
                            String removeIsbn = scanner.nextLine();
                            library.removeBook(removeIsbn);
                            LoadingHelper.simulateLoading();
                            System.out.println("Book removed successfully.");
                            break;

                        case 3:
                            // 查看所有图书
                            LoadingHelper.simulateLoading();
                            library.printLibrary();
                            break;

                        case 4:
                            System.out.println("Exiting...");
                            LoadingHelper.simulateExiting();
                            return;

                        default:
                            System.out.println("Invalid option, try again.");
                    }
                }
            } else {
                System.out.println("Invalid admin credentials. Exiting...");
                LoadingHelper.simulateExiting();
                return;
            }
        } else if (role.equals("user")) {
            // 用户进入
            while (true) {
                System.out.println("\nUser Menu:");
                System.out.println("1. Borrow Book");
                System.out.println("2. Return Book");
                System.out.println("3. View All Books");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        // 借书
                        System.out.print("Enter ISBN of the book to borrow: ");
                        String borrowIsbn = scanner.nextLine();
                        LoadingHelper.simulateLoading();
                        user.borrowBook(library, borrowIsbn);
                        break;

                    case 2:
                        // 还书
                        System.out.print("Enter ISBN of the book to return: ");
                        String returnIsbn = scanner.nextLine();
                        LoadingHelper.simulateLoading();
                        user.returnBook(library, returnIsbn);
                        break;

                    case 3:
                        // 查看所有图书
                        LoadingHelper.simulateLoading();
                        library.printLibrary();
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        LoadingHelper.simulateExiting();
                        return;

                    default:
                        System.out.println("Invalid option, try again.");
                }
            }
        } else {
            System.out.println("Invalid role entered. Exiting...");
            LoadingHelper.simulateExiting();
        }
    }
}
