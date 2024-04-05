package org.riwi.simulacros.simulacro2_2.model;

import org.riwi.simulacros.simulacro2_1.connection.ConfigurationDB;
import org.riwi.simulacros.simulacro2_2.entity.Airplane;
import org.riwi.simulacros.simulacro2_2.repository.CrudRepository;

import java.sql.*;
import java.util.List;

public class AirplaneModel implements CrudRepository {
    Connection objConnection;

    public AirplaneModel() {
        this.objConnection = ConfigurationDB.openConnection();
    }

    @Override
    public void save(Object object) {
        Airplane airplane = (Airplane) object;
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
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public Object find() {
        return null;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }
}
