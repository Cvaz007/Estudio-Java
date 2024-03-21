package org.riwi.bookstore_JDBC.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//! This class will be charge of establishing a connection and close the connection with the database.
public class ConfigurationDB {
    public static Connection connection;
    private static final String USER = "uojvbdsxfwdczgbr";
    private static final String PASSWORD = "DazyValQoy1rmavnjJPG";
    private static final String URL = "jdbc:mysql://bfybdqrcot9xmax6zpsg-mysql.services.clever-cloud.com:3306/bfybdqrcot9xmax6zpsg";
    //This is my way to connect

    public ConfigurationDB() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connection failed");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Connection failed. " + e.getMessage());
            }
        }
    }

    //This is kevin way to connect
    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bfybdqrcot9xmax6zpsg-mysql.services.clever-cloud.com:3306/bfybdqrcot9xmax6zpsg";
            String user = "uojvbdsxfwdczgbr";
            String password = "DazyValQoy1rmavnjJPG";

            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Error. Driver not found");
        } catch (SQLException e) {
            System.err.println("Connection failed. " + e.getMessage());
        }
        return connection;
    }
}
