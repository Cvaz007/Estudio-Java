package org.riwi.JDBC.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//! This class will be charge of establishing a connection and close the connection with the database.
public class ConfigurationDB {
    public  static  Connection connection;
    private static final String USER="root";
    private static final String PASSWORD="1234*";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    //This is my way to connect

    public ConfigurationDB() {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connection was successful");
        }catch (SQLException e){
            System.err.println("Connection failed");
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void closeConnection(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Connection was closed successfully");
            } catch (SQLException e) {
                System.err.println("Connection failed. " + e.getMessage());
            }
        }
    }
    //This is kevin way to connect
    public static  Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "1234*";

            connection = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);

            System.out.println("Connection was successful");
        }catch (ClassNotFoundException e){
            System.err.println("Error. Driver not found");
        }catch (SQLException e){
            System.err.println("Connection failed. " + e.getMessage());
        }        return null;
    }
}
