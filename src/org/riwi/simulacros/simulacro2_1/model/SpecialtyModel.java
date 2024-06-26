package org.riwi.simulacros.simulacro2_1.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_1.entity.Specialty;
import org.riwi.simulacros.simulacro2_1.repository.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialtyModel implements CrudRepository {
    Connection objConnection;

    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Specialty specialty = new Specialty();
        try {
            String sql = "INSERT INTO especialidad (nombre, descripcion) VALUES (?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, specialty.getName());
            statement.setString(2, specialty.getDescription());
            ;

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                specialty.setId(rs.getInt(1));
            }
            System.out.println("specialty insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return specialty;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Specialty specialty = new Specialty();
        try {
            String sql = "UPDATE medico SET nombre = ?, descripcion = ? WHERE id_especialidad = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, specialty.getName());
            statement.setString(2, specialty.getDescription());
            ;
            statement.setInt(3, specialty.getId());


            statement.executeUpdate();

            System.out.println("Specialty was update successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void delete(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Specialty specialty = new Specialty();
        try {
            String sql = "DELETE FROM especialidad WHERE id_especialidad = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, specialty.getId());

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object find(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Specialty specialty;
        try {
            String sql = "SELECT * FROM especialidad WHERE id_especialidad = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, (int) object);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int idSpecialty = resultSet.getInt("id_especialidad");
            String name = resultSet.getString("nombre");
            String description = resultSet.getString("descripcion");

            specialty = new Specialty(idSpecialty, name, description);

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return specialty;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Specialty> specialties = new ArrayList<>();
        try {
            String sql = "SELECT * FROM especialidad";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_especialidad");
                    String name = resultSet.getString("nombre");
                    String description = resultSet.getString("descripcion");

                    Specialty specialty = new Specialty(id, name, description);
                    specialties.add(specialty);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(specialties);
    }

    public Specialty findSpecialtyByName(String name) {
        objConnection = ConfigurationDB.openConnection();
        Specialty specialty;
        try {
            String sql = "SELECT * FROM especialidad WHERE nombre = " + name + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int idSpecialty = resultSet.getInt("id_especialidad");
                String specialtyName = resultSet.getString("nombre");
                String description = resultSet.getString("descripcion");

                specialty = new Specialty(idSpecialty, specialtyName, description);
            }
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return specialty;
    }
}
