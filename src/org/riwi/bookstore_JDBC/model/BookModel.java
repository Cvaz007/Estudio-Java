package org.riwi.bookstore_JDBC.model;


import org.riwi.bookstore_JDBC.configuration.ConfigurationDB;
import org.riwi.bookstore_JDBC.entity.Book;
import org.riwi.bookstore_JDBC.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements BookRepository {
    Connection objConnection;

    @Override
    public List<Book> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Book> books = new ArrayList<Book>();

        try {
            String sql = "SELECT * FROM book";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String title = resultSet.getString("title");
                    String year = resultSet.getString("yearOfPublished");
                    String authorId = resultSet.getString("authorId");
                    double price = resultSet.getDouble("price");

                    Book book = new Book(id, title, authorId, price, year);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return books;
    }

    @Override
    public Book findById(String id) {
        objConnection = ConfigurationDB.openConnection();
        Book book;
        try {
            String sql = "SELECT * FROM book WHERE book.id = " + id + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                String bookId = resultSet.getString("id");
                String title = resultSet.getString("title");
                String year = resultSet.getString("yearOfPublished");
                String authorId = resultSet.getString("authorId");
                double price = resultSet.getDouble("price");

                book = new Book(id, title, authorId, price, year);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return book;
    }

    @Override
    public Book findByTitle(String title) {
        objConnection = ConfigurationDB.openConnection();
        Book book;
        try {
            String sql = "SELECT * FROM book WHERE book.title like '%" + title + "%';";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                String bookId = resultSet.getString("id");
                String titleNew = resultSet.getString("title");
                String year = resultSet.getString("yearOfPublished");
                String authorId = resultSet.getString("authorId");
                double price = resultSet.getDouble("price");

                book = new Book(bookId, titleNew, authorId, price, year);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return book;
    }

    @Override
    public Book findByName(String id) {
        objConnection = ConfigurationDB.openConnection();
        Book book;
        try {
            String sql = "SELECT * FROM book WHERE book.authorId = "+id+";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                String bookId = resultSet.getString("id");
                String titleNew = resultSet.getString("title");
                String year = resultSet.getString("yearOfPublished");
                String authorId = resultSet.getString("authorId");
                double price = resultSet.getDouble("price");

                book = new Book(bookId, titleNew, authorId, price, year);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return book;
    }

    @Override
    public boolean save(Book book) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO book (id,title, authorId, price,yearOfPublished) VALUES (?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthorId());
            statement.setDouble(4, book.getPrice());
            statement.setString(5, book.getYearOfPublished());

            statement.execute();

            System.out.println("Book insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return true;
    }

    @Override
    public boolean update(Book book) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE book SET title = ?, authorId = ?, price = ?, yearOfPublished = ?  WHERE (id = ?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthorId());
            statement.setDouble(3, book.getPrice());
            statement.setString(4, book.getYearOfPublished());
            statement.setString(5, book.getId());


            statement.executeUpdate();

            System.out.println("Book was update successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return true;
    }

    @Override
    public boolean delete(String id) {
        objConnection = ConfigurationDB.openConnection();

        try {
            String sql = "DELETE FROM book WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Book>  getBooksFromAuthor(String idAuthor){
        objConnection = ConfigurationDB.openConnection();
        List<Book> books = new ArrayList<Book>();

        try {
            String sql = "SELECT *FROM book INNER JOIN author ON book.authorId = author.id WHERE author.id = ?;";

            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {

                statement.setString(1,idAuthor);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String title = resultSet.getString("title");
                    String year = resultSet.getString("yearOfPublished");
                    String authorId = resultSet.getString("authorId");
                    double price = resultSet.getDouble("price");

                    Book book = new Book(id, title, authorId, price, year);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return books;
    }
}
