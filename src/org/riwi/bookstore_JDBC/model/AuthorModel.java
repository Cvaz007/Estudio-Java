package org.riwi.bookstore_JDBC.model;

import org.riwi.JDBC.connection.ConfigurationDB;
import org.riwi.bookstore_JDBC.entity.Author;
import org.riwi.bookstore_JDBC.repository.AuthorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel implements AuthorRepository {
    Connection objConnection;

    @Override
    public boolean deleteAuthor(String authorId) {
        objConnection = ConfigurationDB.openConnection();

        try {
            String sql = "DELETE FROM author WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, authorId);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean insertAuthor(Author author) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO author (name, nationality) VALUES (?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, author.getName());
            statement.setString(2, author.getNationality());

            statement.execute();

            System.out.println("Author insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return true;
    }

    @Override
    public boolean updateAuthor(Author author) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE author SET name = ?, nationality = ?  WHERE (id = ?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, author.getName());
            statement.setString(2, author.getNationality());
            statement.setString(3, author.getId());

            statement.executeUpdate();

            System.out.println("Author was update successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return true;
    }

    @Override
    public List<Author> getAllAuthors() {
        objConnection = ConfigurationDB.openConnection();
        List<Author> authors = new ArrayList<Author>();

        try {
            String sql = "SELECT * FROM author";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String name = resultSet.getString("name");
                    String nationality = resultSet.getString("nationality");

                    Author author = new Author(id, name, nationality);
                    authors.add(author);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return authors;
    }

    @Override
    public Author getAuthorById(String authorId) {
        objConnection = ConfigurationDB.openConnection();
        Author author;
        try {
            String sql = "SELECT * FROM author WHERE author.id = " + authorId + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();

                String name = resultSet.getString("name");
                String nationality = resultSet.getString("nationality");
                String id = resultSet.getString("id");

                author = new Author(id, name, nationality);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return author;
    }
}
