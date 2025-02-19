package com.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import com.baseClasses.BaseClass_Web;
import com.components.Dynamicity;

public class DatabaseComponent extends BaseClass_Web {

    // Database details
    //private static final String HOST = "epsv2qa-new-cluster.cluster-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final String HOST = "epsv2-staging-ms-rds-cluster.cluster-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final String HOST_QA = "epsv2qa-cluster.cluster-ro-cvmoajpwxdf3.ap-south-1.rds.amazonaws.com";
    private static final int PORT = 6451;
    private static final String DATABASE_NAME_QA = "epsstaging";
    private static final String DATABASE_NAME = "epsstaging";
    private static final String USERNAME = "readonlyuser";
    private static final String PASSWORD = "readonlyuserC@1389";
    private static final String PASSWORD_QA = "readonlyuserC@1389";
    private static String userPWD = null;
    private static String organizationname = null;
    private static String firstname = null;
    private static String lastname = null;
    private static String email = null;
    private static String companyname = null;
    private static String queryParam = null;
    public static String organizationName = null;
    
    // JDBC URL
    private static final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;
    private static final String JDBC_URL_QA = "jdbc:postgresql://" + HOST_QA + ":" + PORT + "/" + DATABASE_NAME_QA;

    // Connection instance
    private static Connection connection;

    // Constructor to initialize the connection
    public DatabaseComponent() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
    public static void DatabaseComponent_New() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }
    public static void DatabaseComponent_QA() {
        try {
            connection = DriverManager.getConnection(JDBC_URL_QA, USERNAME, PASSWORD_QA);
            
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

   
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to close the database connection");
        }
    }

   
    public void exampleMethod() {
        String query = "SELECT * FROM eps.user_password_details where usercode='HMEL_CREATOR' and currentflag ='Y'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                
                String columnValue = resultSet.getString("password");
                
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
    public static String getQueryParam() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String tem=Dynamicity.getDataFromPropertiesFile("Template", filePath_4);
    	//String usercode=Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4);
        String query = "SELECT * FROM eps.group_template where longname='"+tem+"' and status='A'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                
            	queryParam = resultSet.getString("group_id");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return queryParam;
    }
    public static String getQueryParam(String userCode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String tem=Dynamicity.getDataFromPropertiesFile("Template", filePath_4);
    	//String usercode=Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4);
        String query = "SELECT * FROM eps.group_template where longname='"+tem+"' and orgid =(select orgid from eps.userdetails where usercode='"+userCode+"' and is_active=1) and status='A'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
              
            	queryParam = resultSet.getString("group_id");
               
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return queryParam;
    }
    public static String getQueryParam_ST(String userCode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String tem=Dynamicity.getDataFromPropertiesFile("Template", filePath_4);
    	//String usercode=Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4);
        String query = "SELECT group_id FROM eps.sanction_group where longname='"+tem+"' and orgid =(select orgid from eps.userdetails where usercode='"+userCode+"' and is_active=1) and status='A'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                
            	queryParam = resultSet.getString("group_id");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return queryParam;
    }
    public static String getSanctionID() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String tenderID=Dynamicity.getDataFromPropertiesFile("tenderID", filePath_4);
    	String SanctionCreator=Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4);
        String query = "SELECT * FROM eps.sanction where orgtenderid ='"+tenderID+"' and orgid=(select orgid from eps.userdetails where usercode='"+SanctionCreator+"') order by orgsanctionid desc limit 1";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                
            	queryParam = resultSet.getString("sanction_id");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return queryParam;
    }
    public static String getSanctionID_PR() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String SanctionCreator=Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4);
        String query = "SELECT * FROM eps.sanction where orgid=(select orgid from eps.userdetails where usercode='"+SanctionCreator+"') order by orgsanctionid desc limit 1";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                
            	queryParam = resultSet.getString("sanction_id");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return queryParam;
    }
    public static String getSanctionID_Indent() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String indentID=Dynamicity.getDataFromPropertiesFile("IndentID", filePath_4);
    	String SanctionCreator=Dynamicity.getDataFromPropertiesFile("snCreator", filePath_4);
    	//String usercode=Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4);
        String query = "SELECT * FROM eps.sanction where orgindentid ='"+indentID+"' and orgid=(select orgid from eps.userdetails where usercode='"+SanctionCreator+"') order by orgsanctionid desc limit 1";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
              
            	queryParam = resultSet.getString("sanction_id");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return queryParam;
    }
    public static String getTGname(String userCode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String LongName=null;
    	String tem=Dynamicity.getDataFromPropertiesFile("Template", filePath_4);
    	String tenderID=Dynamicity.getDataFromPropertiesFile("tenderID", filePath_4);
        String query = "select longname from eps.group_template where group_id=(select groupid from eps.tender where orgtenderid ="+tenderID+" and orgid =(select orgid from eps.userdetails where usercode='"+userCode+"'))and status='A'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
            	LongName = resultSet.getString("longname");  
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return LongName;
    }
    public static String organizationName(String tem, String param) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	
        String query = "SELECT * FROM eps.group_template where longname='"+tem+"' and status='A' and group_id="+param+"";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
            	organizationName = resultSet.getString("orgid");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        orgValue=organizationName;
        approvalConfirmMsgRepeat();
        closeConnection();
        return organizationName;
    }
    public static String organizationName(String usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "select * FROM eps.userdetails where usercode ='"+usercode+"'";
        ResultSet resultSet = executeQuery(query);
        try {
            while (resultSet.next()) {
                
            	orgValue = resultSet.getString("orgid");
                

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        approvalConfirmMsgRepeat();
        qC_at_SNCreation(orgValue);
        poSF(orgValue);
        closeConnection();
        return orgValue;
    }
    public static void uc() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "select usercode from eps.userdetails where createid='"+supOrgID+"'";
        ResultSet resultSet = executeQuery(query);
        try {
            while (resultSet.next()) {
            	supOrgID = resultSet.getString("usercode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
    }
    public static String OrgID(String usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String query ="select organizationid FROM eps.user_org where userid = (SELECT user_id FROM eps.userdetails where usercode = '"+usercode+"') order by createdate asc limit 1";
        ResultSet resultSet = executeQuery(query);
        try {
            while (resultSet.next()) {
                
            	depValue = resultSet.getString("organizationid");
                

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return depValue;
    }
    public static String approvalConfirmMsgRepeat() throws IOException {
        String query = "SELECT approval_confirm_msg_repeat FROM eps.org_configuration where orgid ="+orgValue+"";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                
            	approvalConfirmMsgStatus= resultSet.getString("approval_confirm_msg_repeat");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        return approvalConfirmMsgStatus;
    }
    public static String encryptedPWD() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String usercode=Dynamicity.getDataFromPropertiesFile("tokenExtractor", filePath_4);
    	//String usercode=Dynamicity.getDataFromPropertiesFile("TenderCreator", filePath_4);
        String query = "SELECT * FROM eps.userdetails where usercode='"+usercode+"'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                
            	userPWD = resultSet.getString("password");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return userPWD;
    }
    public static String encryptedPWD_AferTenderCreation(String SN) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String usercode=SN;
        String query = "SELECT * FROM eps.userdetails where usercode='"+usercode+"'";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
               
            	userPWD = resultSet.getString("password");
               
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return userPWD;
    }
    
    public static String firstname(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String Buyer=Dynamicity.getDataFromPropertiesFile(Usercode, filePath_4);
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Buyer+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                
            	firstname = resultSet.getString("firstname");
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return firstname;
    }
    
    public static String lastname(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	String Buyer=Dynamicity.getDataFromPropertiesFile(Usercode, filePath_4);
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Buyer+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                
            	lastname = resultSet.getString("lastname");
                
                
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
    	String Buyer=Dynamicity.getDataFromPropertiesFile(Usercode, filePath_4);
        String query = "SELECT * FROM eps.userdetails where usercode = '"+Buyer+"'";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                
            	email = resultSet.getString("email");
                
                
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
    	String Buyer=Dynamicity.getDataFromPropertiesFile(Usercode, filePath_4);
        String query = "SELECT * FROM eps.organization where organization_id= (select cast (RIGHT(REPLACE(RTRIM(identifystring), '.', ''), 4)AS INT) AS last_four_digits\n" + 
        		"FROM eps.user_org where userid = (SELECT user_id FROM eps.userdetails where usercode = '"+Buyer+"'))";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	organizationname = resultSet.getString("organizationname");
                //System.out.println("Value: " + organizationname);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return organizationname;
    }
    public static String organizationname_New() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	//String Buyer=Dynamicity.getDataFromPropertiesFile(Usercode, filePath_4);
        String query = "SELECT * FROM eps.organization where organization_id="+orgValue+"";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	organizationname = resultSet.getString("organizationname");
                //System.out.println("Value: " + organizationname);
                
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
        formattedString.append(firstname).append("  ");
        
        // Append lastname and single space
        lastname=lastname(UserName);
        formattedString.append(lastname).append(" ");
        
        // Append email in parentheses
        email=email(UserName);
        formattedString.append("(").append(email).append(")");
        
        // Append hyphen and organization name
        organizationname=organizationname(UserName);
        formattedString.append("-").append(organizationname);
        
        //System.out.println(formattedString.toString());
        return formattedString.toString();
    } 
    public static String SupplierCompanyName(String Usercode) throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	//String Buyer=Dynamicity.getDataFromPropertiesFile(Usercode, filePath_4);
        String query = "SELECT * FROM eps.vendor where vendor_id =(SELECT vendorid FROM eps.userdetails where usercode = '"+Usercode+"')";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	companyname = resultSet.getString("companyname");
                //System.out.println("Value: " + companyname);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return companyname;
    }
    public static void Decode() {
        String hashedPassword = "$2a$12$JSL1M6312345678901234um2VeHWnFJcJ/H9D2Vfgm8euI2JiKbaq";
        String passwordAttempt = "pass@123";

        // Check if the password matches the hash
        if (BCrypt.checkpw(passwordAttempt, hashedPassword)) {
            //System.out.println("Password is correct!");
        } else {
            //System.out.println("Password is incorrect.");
        }
    }
    public static String OTP_SupplierRegistration() throws IOException {
    	String mailbody=null;
    	String otp=null;
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "select * from eps.mail_details where eventid=132 order by create_timestamp desc  limit 1";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                // Process the result set
            	mailbody = resultSet.getString("mail_body");
                //System.out.println("Value: " + mailbody);
                String input=mailbody;
                String regex = "\\b(\\d{6})\\b";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
                if (matcher.find()) {
                    otp = matcher.group(1);
                    //System.out.println("OTP found: " + otp);
                } else {
                    //System.out.println("No OTP found");
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        closeConnection();
        return otp;
    }
    public static void sysTID() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
        String query = "select tender_id from eps.tender where orgtenderid="+tID+" and orgid="+orgValue+"";
        ResultSet resultSet = executeQuery(query);
        try {
            if (resultSet.next()) {
            	sTID = resultSet.getString("tender_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        } 
        closeConnection();
    }
    public static void sysIID() throws IOException {
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	int iID=Integer.parseInt(Dynamicity.getDataFromPropertiesFile("IndentID", filePath_4));
        String query = "select indent_id from indent.indent where orgindentid="+iID+" and orgid="+orgValue+"";
        ResultSet resultSet = executeQuery(query);
        try {
            if (resultSet.next()) {
            	sIID = resultSet.getString("indent_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        } 
        System.out.println(sIID);
        closeConnection();
    }
    public static void stID() throws IOException {
        String query = "select tender_id  from eps.tender where orgtenderid="+tID+" and orgid ="+orgValue+"";
        ResultSet resultSet = executeQuery(query);
        try {
            if (resultSet.next()) {
            	sTID = resultSet.getString("tender_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        } 
    }
	public static void vID() throws IOException {
	        String query = "select vendorid from eps.userdetails where usercode='"+user+"'";
	        ResultSet resultSet = executeQuery(query);
	        try {
	            if (resultSet.next()) {
	            	vID = resultSet.getString("vendorid");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Error processing result set");
	        } 
	    }
	public static void vUID() throws IOException {
        String query = "select user_id from eps.userdetails where usercode='"+user+"'";
        ResultSet resultSet = executeQuery(query);
        try {
            if (resultSet.next()) {
            	vUID = resultSet.getString("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
    }
	public static void dQID() throws IOException {
        String query = "select * from eps.draftquotation where tenderid="+sTID+" and vendorid="+vID+" order by draftquotation_id desc limit 1";
        ResultSet resultSet = executeQuery(query);
        try {
            if (resultSet.next()) {
            	dQID = resultSet.getString("draftquotation_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        } 
    }
    public static String isMailTriggered(int eventId, int time) throws IOException{
    	if(Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
    		DatabaseComponent_QA();
    	}
    	else {
    	DatabaseComponent_New();
    	}
    	//String Buyer=Dynamicity.getDataFromPropertiesFile(Usercode, filePath_4);
        String query = "SELECT * FROM eps.mail_details WHERE eventid = "+eventId+" AND create_timestamp >= (CURRENT_TIMESTAMP - INTERVAL '"+time+" minute')ORDER BY create_timestamp desc LIMIT 1";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	mailID = resultSet.getString("mail_id");
                //System.out.println("Value: " + mailID);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        //closeConnection();
        return mailID;
    }
    
    public static String isMailAttachmentPresent(int eventId, int time) throws IOException {
    	List<String> fileName=new ArrayList<>();
    	String AttachmentName;
    	AttachmentCount=0;
    	String mailid=isMailTriggered(eventId, time);
    	//System.out.println("MailID is: "+mailid);
        String query = "select * from eps.mail_attachment where mailid ="+mailid+"";
        ResultSet resultSet = executeQuery(query);

        try {
            while (resultSet.next()) {
                // Process the result set
            	AttachmentName = resultSet.getString("filename");
                //System.out.println("Value: " + AttachmentName);
                fileName.add(AttachmentName);
                AttachmentCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
        
        closeConnection();
        return fileName.toString();
    }
    public static String countMappedTender(String indentTemplateGroupId) throws IOException {
        // Choose the database component based on the environment
        if (Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
            DatabaseComponent_QA();
        } else {
            DatabaseComponent_New();
        }

        String query = "select count(distinct group_id) as distinct_tender_count from eps.group_template gt where group_id in (\r\n" + 
        		"select distinct tender_groupid from indent.indent_tender_mapping itm\r\n" + 
        		"where indent_groupid =" + indentTemplateGroupId + " and is_active =1);";
        
        ResultSet resultSet = executeQuery(query);
        String distinctTenderCount = null;

        try {
            if (resultSet.next()) {
                distinctTenderCount = resultSet.getString("distinct_tender_count");
                //System.out.println("Distinct Tender Count: " + distinctTenderCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        } finally {
            closeConnection();  
        }

        return distinctTenderCount;
    }
    public static void qC_at_SNCreation(String orgID) throws IOException {
        String query = "select quantity_check_at_sn_creatioin from eps.org_configuration where orgid ="+orgID+"";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	qCSN = resultSet.getString("quantity_check_at_sn_creatioin");
                //System.out.println("Value: " + qCSN);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
    }
    public static void poSF(String orgID) throws IOException {
        String query = "select posourceflag from eps.org_configuration where orgid ="+orgID+"";
        ResultSet resultSet = executeQuery(query);
        
        try {
            while (resultSet.next()) {
                // Process the result set
            	psf = resultSet.getString("posourceflag");
                //System.out.println("Value: " + psf);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing result set");
        }
    }
    public static void bD() throws IOException {
        // Choose the database component based on the environment
        if (Dynamicity.getDataFromPropertiesFile("Environment", filePath_4).equalsIgnoreCase("QA")) {
            DatabaseComponent_QA();
        } else {
            DatabaseComponent_New();
        } 
        stID();vID();vUID();dQID();
        closeConnection();  
    }

    // Main method for testing
    public static void main(String[] args) throws Exception {
    	
//    	organizationName("GSML_BUYER");
    	organizationName("HPCL_AUTOMATION_TC");

    	
    }
}