package com.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseComponent {

    // Database details
    //private static final String HOST = "epsv2qa-new-cluster.cluster-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final String HOST = "epsv2-staging-ms-rds-cluster.cluster-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final int PORT = 6451;
    //private static final String DATABASE_NAME = "epsprod";
    private static final String DATABASE_NAME = "epsstaging";
    private static final String USERNAME = "epsuser";
    private static final String PASSWORD = "epsuser123";
    private static String userPWD = null;

    // JDBC URL
    private static final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;

    // Connection instance
    private static Connection connection;

    // Constructor to initialize the connection
    public DatabaseComponent() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
    public static void DatabaseComponent_New() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }

    // Execute a query and return the result set
    public static ResultSet executeQuery(String query) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute query");
        }
    }

    // Close the database connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to close the database connection");
        }
    }

    // Example method to demonstrate usage
    public void exampleMethod() {
        String query = "SELECT * FROM eps.user_password_details where usercode='HMEL_CREATOR' and currentflag ='Y'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                // Process the result set
                String columnValue = resultSet.getString("password");
                System.out.println("Value: " + columnValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
    }
    /*
    public static String getValueFromDatabase(String tableName, String columnName, int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT " + columnName + " FROM " + tableName + " WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString(columnName);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    */ 
    public static String encryptedPWD() {
    	DatabaseComponent_New();
        String query = "SELECT * FROM eps.user_password_details where usercode='HMEL_CREATOR' and currentflag ='Y'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                // Process the result set
            	userPWD = resultSet.getString("password");
                System.out.println("Value: " + userPWD);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return userPWD;
    }
    

    // Main method for testing
    public static void main(String[] args) throws SQLException {
    	
       // DatabaseComponent databaseConnector = new DatabaseComponent();
        
        //databaseConnector.exampleMethod();
    	//DatabaseComponent_New();
        encryptedPWD();
       // DatabaseComponent.closeConnection();
        
    	
    }
}