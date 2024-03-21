package org.riwi.bookstore_JDBC.repository;

import org.riwi.bookstore_JDBC.entity.Author;

import java.util.List;

public interface AuthorRepository {
    boolean deleteAuthor(String authorId);
    boolean insertAuthor(Author author);
    boolean updateAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(String authorId);
    Author getAuthorByName(String name);
}
