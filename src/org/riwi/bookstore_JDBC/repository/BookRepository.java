package org.riwi.bookstore_JDBC.repository;

import org.riwi.bookstore_JDBC.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(String id);
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(String id);
}
