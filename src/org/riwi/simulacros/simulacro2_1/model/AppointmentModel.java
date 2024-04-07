package org.riwi.simulacros.simulacro2_1.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_1.entity.Appointment;
import org.riwi.simulacros.simulacro2_1.repository.CrudRepository;
import org.riwi.simulacros.simulacro2_1.repository.JoinTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppointmentModel implements CrudRepository {
    Connection objConnection;


    @Override
    public Object save(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Appointment appointment = (Appointment) object;
        try {
            String sql = "INSERT INTO cita (id_paciente, id_medico, fecha_cita,hora,motivo) VALUES (?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());
            statement.setDate(3, (Date) appointment.getDate());
            statement.setDate(4, (Date) appointment.getTime());
            statement.setString(5, appointment.getReason());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                appointment.setId(rs.getInt(1));
            }
            System.out.println("Appointment insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return appointment;
    }

    @Override
    public void update(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Appointment appointment = (Appointment) object;
        try {
            String sql = "UPDATE cita SET id_paciente = ?, id_medico = ?, fecha_cita = ?, hora = ?, motivo = ? WHERE id_cita = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);

            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());
            statement.setDate(3, (Date) appointment.getDate());
            statement.setDate(4, (Date) appointment.getTime());
            statement.setString(5, appointment.getReason());
            statement.setInt(6, appointment.getId());

            statement.executeUpdate();
            System.out.println("Appointment was update successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void delete(Object object) {
        objConnection = ConfigurationDB.openConnection();
        Appointment appointment = (Appointment) object;
        try {
            String sql = "DELETE FROM cita WHERE id_cita = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, appointment.getId());

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
        Appointment appointment;
        try {
            String sql = "SELECT * FROM cita WHERE id_cita = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, (int) object);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int idDoctor = resultSet.getInt("id_medico");
            int idDate = resultSet.getInt("id_cita");
            int idPatient = resultSet.getInt("id_paciente");
            Date date = resultSet.getDate("fecha_cita");
            Date time = resultSet.getDate("hora");
            String reason = resultSet.getString("motivo");

            appointment = new Appointment(idDate, idDoctor, idPatient, date, time, reason);

        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return appointment;
    }

    @Override
    public List<Object> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Appointment> appointments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cita";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idDoctor = resultSet.getInt("id_medico");
                    int idDate = resultSet.getInt("id_cita");
                    int idPatient = resultSet.getInt("id_paciente");
                    Date date = resultSet.getDate("fecha_cita");
                    Date time = resultSet.getDate("hora");
                    String reason = resultSet.getString("motivo");

                    Appointment appointment = new Appointment(idDate, idDoctor, idPatient, date, time, reason);
                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return Collections.singletonList(appointments);
    }

    public Appointment findAppointmentByDate(java.util.Date date) {
        objConnection = ConfigurationDB.openConnection();
        Appointment appointment;
        try {
            String sql = "SELECT * FROM cita WHERE fecha_cita = " + date + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int idDoctor = resultSet.getInt("id_medico");
                int idDate = resultSet.getInt("id_cita");
                int idPatient = resultSet.getInt("id_paciente");
                Date time = resultSet.getDate("hora");
                String reason = resultSet.getString("motivo");

                appointment = new Appointment(idDate, idDoctor, idPatient, date, time, reason);
            }
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return appointment;
    }
}

