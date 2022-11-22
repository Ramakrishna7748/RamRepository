package com.snowflake.setup;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SnowflakeMFA {



//		String user = "<Chowdarykrishna023@gmail.com>";          // replace "<user>" with your user name
//		String password = "<password>";  // replace "<password>" with your password
//		Connection con = DriverManager.getConnection("jdbc:snowflake://<account>.snowflakecomputing.com/", user, password);

		
	public static void main(String[] args) throws SQLException, IOException 
	{

			
		    // get connection
		    Connection conn = getConnection(); 
		    System.out.println("Create JDBC connection");
		   
		    System.out.println("Done creating JDBC connectionn");
		    // create statement
		    System.out.println("Create JDBC statement");
		    Statement statement =conn.createStatement();
		    System.out.println("Done creating JDBC statementn");
		    
		    //use TEST_DB Database
		    statement.executeUpdate("USE Database TEST_DB") ;
		    //use warehouse
		    statement.executeUpdate("use warehouse MY_WH") ;
	    	System.out.println("Use warehouse works");
		    // create a table
		    statement.executeUpdate("create or replace table Designation_Master  (" +"ID int,"+" NAME varchar(20),"+" LEVEL varchar(20) )");
	    	System.out.println("Designation_Master Table created");

	    	 //Insert values Into Table
	    	 statement.executeUpdate("insert into Designation_Master values (1,'Software engineer',1)");
	    	 statement.executeUpdate("insert into Designation_Master values (2,'manager',2)");
	    	 statement.executeUpdate("insert into Designation_Master values (3,'testing',3)");
			 System.out.println("Inserted values into Designation_Master Table ");
			 
			 statement.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
			 //Retriew Table Data
			 ResultSet resultSet1 = statement.executeQuery("SELECT * FROM Designation_Master");
			 System.out.println("select statement works");
   		 	 while (resultSet1.next()) 
   		 	 {
	         int ID = resultSet1.getInt("ID");
	         String NAME=resultSet1.getString("NAME");
	         String LEVEL=resultSet1.getString("LEVEL");
	         System.out.println(ID + ", " + NAME + ", " + LEVEL);
   		 	 }
   		 	 
	}
		  
	
		   private static Connection getConnection() throws SQLException, IOException
		   {
			Properties prop =new Properties();
			FileInputStream fis;
			fis = new FileInputStream("./src/main/java/com/snowflake/config/properties");
			prop.load(fis);
   
		    // build connection properties
		    Properties properties = new Properties();
		    properties.put("user", prop.getProperty("username"));     //  username
		    properties.put("password", prop.getProperty("password")); // password
		    properties.put("account", "gw79119.central-india.azure");  //  your account name
		    properties.put("db", "DEMO_DB1");       // database name
		    properties.put("schema", "DEMO_SCHEMA");   // replace "" with target schema name
		    properties.put("role", "ACCOUNTADMIN");

		    String connectStr = "jdbc:snowflake://gw79119.central-india.azure.snowflakecomputing.com/?user=Ramakrishna&passcode=990405"; // replace accountName with your account name

		    return DriverManager.getConnection(connectStr, properties);
		  }
	
		   
	}





