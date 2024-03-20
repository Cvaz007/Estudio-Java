package org.riwi.bookstore_JDBC.controller;

import org.riwi.bookstore_JDBC.entity.Author;
import org.riwi.bookstore_JDBC.entity.Book;
import org.riwi.bookstore_JDBC.model.BookModel;

import java.util.Scanner;

public class BookController {
    BookModel objBook;
    Scanner objScanner;

    public BookController() {
        this.objScanner = new Scanner(System.in);
        this.objBook = new BookModel();
    }

    public void findAll() {
        System.out.println("============ BOOKS ============");
        for (Book book : objBook.findAll()) {
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthorId());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Year: " + book.getYearOfPublished());
            System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");
        }
    }

    public void findById() {
        System.out.print("Type the book id: ");
        String id = objScanner.next();

        Book book = objBook.findById(id);

        System.out.println("============ BOOK ============");
        System.out.println("Id: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthorId());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Year: " + book.getYearOfPublished());
    }

    public boolean save() {
        String id = String.valueOf(System.currentTimeMillis());
        System.out.print("Type the book title: ");
        String title = objScanner.next();
        System.out.print("Type the year of published: ");
        String year = objScanner.next();
        System.out.print("Type the book author id: ");
        String authorId = objScanner.next();
        System.out.print("Type the book price: ");
        double price = objScanner.nextDouble();

        return objBook.save(new Book(id, title, authorId, price, year));
    }

    public boolean update() {
        System.out.print("Type the book id: ");
        String id = objScanner.next();
        System.out.print("Type the book title: ");
        String title = objScanner.next();
        System.out.print("Type the year of published: ");
        String year = objScanner.next();
        System.out.print("Type the book author id: ");
        String authorId = objScanner.next();
        System.out.print("Type the book price: ");
        double price = objScanner.nextDouble();

        return objBook.update(new Book(id, title, authorId, price, year));
    }

    public boolean delete() {
        System.out.print("Type the book id: ");
        String id = objScanner.next();

        return objBook.delete(id);
    }

    public void findByName() {
        AuthorController controller = new AuthorController();
        System.out.print("Type the author name: ");
        String name = objScanner.next();

        Author author = controller.findByName(name);

        Book book = objBook.findByName(author.getId());

        System.out.println("============ BOOK ============");
        System.out.println("Id: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthorId());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Year: " + book.getYearOfPublished());
    }

    public void findByTitle() {
        System.out.print("Type the book title: ");
        String tile = objScanner.next();

        Book book = objBook.findByTitle(tile);

        System.out.println("============ BOOK ============");
        System.out.println("Id: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthorId());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Year: " + book.getYearOfPublished());
    }

    public void getBooksFromAuthor() {
        AuthorController controller = new AuthorController();
        Scanner scanner = new Scanner(System.in);

        controller.getAllAuthors();
        System.out.print("Type the author id: ");
        String id = scanner.next();

        System.out.println("============ BOOKS BY AUTHOR ============");
        for (Book book : objBook.getBooksFromAuthor(id)){
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthorId());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Year: " + book.getYearOfPublished());
            System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");
        }
    }
}
