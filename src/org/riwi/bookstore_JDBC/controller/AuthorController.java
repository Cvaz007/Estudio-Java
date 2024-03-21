package org.riwi.bookstore_JDBC.controller;

import org.riwi.bookstore_JDBC.entity.Author;
import org.riwi.bookstore_JDBC.model.AuthorModel;

import java.util.Scanner;

public class AuthorController {
    AuthorModel objAuthor;
    Scanner objScanner;

    public AuthorController() {
        this.objAuthor = new AuthorModel();
        this.objScanner = new Scanner(System.in);
    }

    public boolean updateAuthor() {
        System.out.print("Enter the author id: ");
        String id = objScanner.next();
        System.out.print("Enter the author name: ");
        String name = objScanner.next();
        System.out.print("Enter the author nationality: ");
        String nationality = objScanner.next();

        return objAuthor.updateAuthor(new Author(id, name, nationality));
    }

    public boolean insertAuthor() {
        String id = String.valueOf(System.currentTimeMillis());
        System.out.print("Enter the author name: ");
        String name = objScanner.next();
        System.out.print("Enter the author nationality: ");
        String nationality = objScanner.next();

        return objAuthor.insertAuthor(new Author(id, name, nationality));
    }

    public boolean deleteAuthor() {
        System.out.print("Enter the author id: ");
        String id = objScanner.next();

        return objAuthor.deleteAuthor(id);
    }

    public void getAllAuthors() {

        System.out.println("============ AUTHORS ============");
        for (Author author : objAuthor.getAllAuthors()){
            System.out.println("Id: " + author.getId());
            System.out.println("Name: " + author.getName());
            System.out.println("Nationality: " + author.getNationality());
            System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");
        }
    }

    public void getAuthorById() {
        System.out.print("Enter the author id: ");
        String id = objScanner.next();

        Author author = objAuthor.getAuthorById(id);

        System.out.println("============ AUTHORS ============");
        System.out.println("Id: " + author.getId());
        System.out.println("Name: " + author.getName());
        System.out.println("Nationality: " + author.getNationality());
        System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");
    }

    public Author findByName(String name) {
        Author author = objAuthor.getAuthorByName(name);

//        System.out.println("============ AUTHORS ============");
//        System.out.println("Id: " + author.getId());
//        System.out.println("Name: " + author.getName());
//        System.out.println("Nationality: " + author.getNationality());
//        System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");

        return author;
    }

}
