package org.riwi.bookstore_JDBC;

import org.riwi.bookstore_JDBC.controller.AuthorController;
import org.riwi.bookstore_JDBC.controller.BookController;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public void menuAuthor() {
        int option = -1;
        AuthorController controller = new AuthorController();
        do {
            menus(false);
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    controller.insertAuthor();
                    break;
                case 2:
                    controller.getAllAuthors();
                    controller.updateAuthor();
                    break;
                case 3:
                    controller.getAllAuthors();
                    controller.deleteAuthor();
                    break;
                case 4:
                    controller.getAllAuthors();
                    break;
                case 5:
                    controller.getAuthorById();
                    break;
            }
        } while (option != 0);
    }

    public void menuBook() {
        int option = -1;
        BookController controller = new BookController();

        do {
            menus(true);
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    controller.save();
                    break;
                case 2:
                    controller.findAll();
                    controller.update();
                    break;
                case 3:
                    controller.findAll();
                    controller.delete();
                    break;
                case 4:
                    controller.findAll();
                    break;
                case 5:
                    controller.findById();
                    break;
                case 6:
                    controller.findByName();
                    break;
                case 7:
                    controller.findByTitle();
                    break;
                case 8:
                    controller.getBooksFromAuthor();
                    break;
            }
        } while (option != 0);
    }

    public static void menus(boolean flag) {
        if (flag) {

            System.out.println("""
                    =============== BOOK ================
                    1. Create an book.
                    2. Update an book.
                    3. Delete an book.
                    4. List all books.
                    5. List book by id
                    6. List book by author name.
                    7. List book by title.
                    8. Get books with author.
                    0. Exit.
                    """);
        } else {
            System.out.println("""
                    =============== AUTHOR ================
                    1. Create an author.
                    2. Update an author.
                    3. Delete an author.
                    4. List all authors.
                    5. List author by id.
                    0. Exit.
                    """);
        }
    }

    public static void menu() {
        Main main = new Main();

        int option = -1;
        do {
            System.out.println("1. Author options || 2. Book options || 0. exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    main.menuAuthor();
                    break;
                case 2:
                    main.menuBook();
                    break;
            }
        } while (option != 0);
    }
}
