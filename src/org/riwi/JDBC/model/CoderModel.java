package org.riwi.JDBC.model;

import org.riwi.JDBC.connection.ConfigurationDB;
import org.riwi.JDBC.entity.Coder;
import org.riwi.JDBC.repository.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements CRUD {

    Connection objConnection;

    @Override
    public Object insert(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Coder coder = (Coder) object;
        try {
            String sql = "INSERT INTO coder (name, age, clan) VALUES (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, coder.getName());
            statement.setInt(2, coder.getAge());
            statement.setString(3, coder.getClan());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                coder.setId(rs.getInt(1));
            }
            System.out.println("Coder insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return object;
    }

    @Override
    public boolean update(Object object) {
        Coder coder = (Coder) object;
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE coder SET name = ?, age = ?, clan = ? WHERE (id = ?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, coder.getName());
            statement.setInt(2, coder.getAge());
            statement.setString(3, coder.getClan());
            statement.setInt(4, coder.getId());


            statement.executeUpdate();

            System.out.println("Coder was update successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return false;
    }

    @Override
    public boolean delete(int id) {
        objConnection = ConfigurationDB.openConnection();

        try{
            String sql = "DELETE FROM coder WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1,id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Object> coderList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM coder";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int coderId = resultSet.getInt("id");
                    int age = resultSet.getInt("age");
                    String name = resultSet.getString("name");
                    String clan = resultSet.getString("clan");

                    Coder coder = new Coder(coderId, name, age, clan);
                    coderList.add(coder);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return coderList;
    }

    @Override
    public Object findById(int id) {
        objConnection = ConfigurationDB.openConnection();
        Object coder;
        try {
            String sql = "SELECT * FROM coder WHERE coder.id = " + id + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int coderId = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                String clan = resultSet.getString("clan");

                coder = new Coder(coderId, name, age, clan);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return coder;
    }
}
