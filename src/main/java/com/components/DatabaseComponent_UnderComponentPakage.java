package com.components;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baseClasses.BaseClass_Web;

public class DatabaseComponent_UnderComponentPakage extends BaseClass_Web{

    // Database details
    //private static final String HOST = "epsv2qa-new-cluster.cluster-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final String HOST = "epsv2-staging-ms-rds-cluster.cluster-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final String HOST_QA = "epsv2qa-cluster.cluster-ro-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final int PORT = 6451;
    private static final String DATABASE_NAME_QA = "epsstaging";
    private static final String DATABASE_NAME = "epsstaging";
    private static final String USERNAME = "readonlyuser";
    private static final String PASSWORD = "readonlyuserC@1389";
    private static final String PASSWORD_QA = "readonlyuserC@138";
    private static String userPWD = null;
    private static String organizationname = null;
    private static String salutation = null;
    private static String firstname = null;
    private static String middlename = null;
    private static String lastname = null;
    private static String email = null;
    private static String companyname = null;

    // JDBC URL
    private static final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;
    private static final String JDBC_URL_QA = "jdbc:postgresql://" + HOST_QA + ":" + PORT + "/" + DATABASE_NAME_QA;

    // Connection instance
    private static Connection connection;

    // Constructor to initialize the connection
    public DatabaseComponent_UnderComponentPakage() {
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
    public static void DatabaseComponent_QA() {
        try {
            connection = DriverManager.getConnection(JDBC_URL_QA, USERNAME, PASSWORD_QA);
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
    public static String salutation(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Usercode+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	salutation = resultSet.getString("salutation");
                System.out.println("Value: " + salutation);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return salutation;
    }
    public static String firstname(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Usercode+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	firstname = resultSet.getString("firstname");
                System.out.println("Value: " + firstname);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return firstname;
    }
    public static String middlename(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Usercode+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	middlename = resultSet.getString("middlename");
                System.out.println("Value: " + middlename);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return middlename;
    }
    public static String lastname(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Usercode+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	lastname = resultSet.getString("lastname");
                System.out.println("Value: " + lastname);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return lastname;
    }
    
    public static String email(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Usercode+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	email = resultSet.getString("email");
                System.out.println("Value: " + email);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return email;
    }
        
    public static String organizationname(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	/*
        String query = "SELECT * FROM eps.organization where organization_id= (select cast (RIGHT(REPLACE(RTRIM(identifystring), '.', ''), 4)AS INT) AS last_four_digits\n" + 
        		"FROM eps.user_org where userid = (SELECT user_id FROM eps.userdetails where usercode = '"+Usercode+"'))";
        */
    	String query =
    			"SELECT * FROM eps.organization where organization_id=(select organizationid FROM eps.user_org where userid = (SELECT user_id FROM eps.userdetails where usercode = '"
    			+Usercode+
    			"') order by createdate asc limit 1)";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	organizationname = resultSet.getString("organizationname");
                System.out.println("Value: " + organizationname);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return organizationname;
    }
    
    public static String formatUserInfo(String UserName) throws IOException {
        StringBuilder formattedString = new StringBuilder();
        // Append firstname and double space
        firstname= firstname(UserName);
        //formattedString.append(firstname).append("  ");
        //middlename
        int mSize=0;
        middlename= middlename(UserName);
        if(!(middlename==null)){
        mSize=middlename.length();
        }
        if(mSize==0) {
        	 formattedString.append(firstname).append("  ");
        	System.out.println(middlename);
        }
        else {
        	 formattedString.append(firstname).append(" ");
        formattedString.append(middlename).append(" ");
        }
        // Append lastname and single space
        lastname=lastname(UserName);
        formattedString.append(lastname).append(" ");
        
        // Append email in parentheses
        email=email(UserName);
        formattedString.append("(").append(email).append(")");
        
        // Append hyphen and organization name
        organizationname=organizationname(UserName);
        formattedString.append("-").append(organizationname);
        
        System.out.println(formattedString.toString());
        return formattedString.toString();
    }
    public static String userFNandLN(String UserName) throws IOException {
        StringBuilder formattedString = new StringBuilder();
        // Append firstname and double space
        firstname= firstname(UserName);
        formattedString.append(firstname).append(" ");
        
        // Append lastname and single space
        lastname=lastname(UserName);
        formattedString.append(lastname);
        
        System.out.println(formattedString.toString());
        return formattedString.toString();
    }
    public static String userFullName(String UserName) throws IOException {
        StringBuilder formattedString = new StringBuilder();
        // Append firstname and double space
        
        salutation= salutation(UserName);
        formattedString.append(salutation).append(" ");
        
        firstname= firstname(UserName);
        formattedString.append(firstname).append(" ");
        
        // Append lastname and single space
        lastname=lastname(UserName);
        formattedString.append(lastname);

        System.out.println(formattedString.toString());
        return formattedString.toString();
    }
    public static String SupplierCompanyName(String Usercode){
    	DatabaseComponent_New();
        String query = "SELECT * FROM eps.vendor where vendor_id =(SELECT vendorid FROM eps.userdetails where usercode = '"+Usercode+"')";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	companyname = resultSet.getString("companyname");
                System.out.println("Value: " + companyname);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return companyname;
    }
    

    // Main method for testing
    public static void main(String[] args) throws SQLException, IOException {
    	
       // DatabaseComponent databaseConnector = new DatabaseComponent();
        
        //databaseConnector.exampleMethod();
    	//DatabaseComponent_New();
       // encryptedPWD();
        //SupplierCompanyName("MJSUPPLIER14");
       // DatabaseComponent.closeConnection();
//        userFullName("RDCIS_APPROVER2");
    	formatUserInfo("RDCISSTG_INDENTAPPROVER1");
//        userFNandLN("BIDDERAPPROVER");
    	
    }
}