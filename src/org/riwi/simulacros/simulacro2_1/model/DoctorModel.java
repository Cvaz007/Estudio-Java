package org.riwi.simulacros.simulacro2_1.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_1.entity.Doctor;
import org.riwi.simulacros.simulacro2_1.repository.CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorModel implements CrudRepository {
    Connection objConnection;

    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Doctor doctor = (Doctor) object;
        try {
            String sql = "INSERT INTO medico (nombre, apellidos, id_especialidad) VALUES (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getLastName());
            statement.setInt(3, doctor.getspecialtyId());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                doctor.setId(rs.getInt(1));
            }
            System.out.println("Doctor insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return doctor;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Doctor doctor = (Doctor) object;

        try {
            String sql = "UPDATE medico SET nombre = ?, apellidos = ?, id_especialidad = ? WHERE id_medico = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getLastName());
            statement.setInt(3, doctor.getspecialtyId());
            statement.setInt(4, doctor.getId());


            statement.executeUpdate();

            System.out.println("Doctor was update successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void delete(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Doctor doctor = (Doctor) object;
        try {
            String sql = "DELETE FROM medico WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1,  doctor.getId());

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public Object find(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Doctor doctor;
        try {
            String sql = "SELECT * FROM medico WHERE id_medico =  ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, (int) object);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int idDoctor = resultSet.getInt("id_medico");
            int idSpecialty = resultSet.getInt("id_especialidad");
            String name = resultSet.getString("nombre");
            String lastName = resultSet.getString("apellidos");

            doctor = new Doctor(idDoctor, name, lastName, idSpecialty);

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return doctor;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Doctor> doctors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medico";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_medico");
                    int idSpecialty = resultSet.getInt("id_especialidad");
                    String name = resultSet.getString("nombre");
                    String lastName = resultSet.getString("apellidos");

                    Doctor doctor = new Doctor(id, name, lastName, idSpecialty);
                    doctors.add(doctor);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(doctors);
    }

    public List<Doctor> findDoctorBySpecialty(Object specialtyId) {
        objConnection = ConfigurationDB.openConnection();
        List<Doctor> doctors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medico WHERE id_especialidad = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, (int) specialtyId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_medico");
                int idSpecialty = resultSet.getInt("id_especialidad");
                String name = resultSet.getString("nombre");
                String lastName = resultSet.getString("apellidos");

                Doctor doctor = new Doctor(id, name, lastName, idSpecialty);
                doctors.add(doctor);
            }

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return doctors;
    }
}

