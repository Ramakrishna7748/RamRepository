package com.snowflake.setup;

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


public class Snowflake_Setup {



//		String user = "<Chowdarykrishna023@gmail.com>";          // replace "<user>" with your user name
//		String password = "<password>";  // replace "<password>" with your password
//		Connection con = DriverManager.getConnection("jdbc:snowflake://<account>.snowflakecomputing.com/", user, password);

		
	public static void main(String[] args) throws SQLException {

		  {
		    // get connection
		    Connection conn = getConnection(); 
		    System.out.println("Create JDBC connection");
		   
		    System.out.println("Done creating JDBC connectionn");
		    // create statement
		    System.out.println("Create JDBC statement");
		    Statement statement =conn.createStatement();
		    System.out.println("Done creating JDBC statementn");
		    // create a table
		    
		    
		    statement.executeUpdate("USE Database TEST_DB") ;
		  
		    System.out.println("Create demo table");
//		    statement.executeUpdate("create database TEST_DB");
		    statement.executeUpdate("create or replace table demo4(C1 STRING)");
//		    statement.close();
		    System.out.println("Done creating demo tablen");
		    // insert a row
		    System.out.println("Insert 'hello world'");
		    String warehouseName="use warehouse MY_WH";
	   	    statement.executeUpdate(warehouseName);
		    
		    statement.executeUpdate("insert into demo4 values ('hello world')");
		    
//		    statement.close();
		    System.out.println("Done inserting 'hello world'n");
		    // query the data
		    System.out.println("Query demo");
		    
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM demo4");
		  //  System.out.println("Metadata:");
		    System.out.println("================================");
		    // fetch metadata
//		    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//		    System.out.println("Number of columns=" +
//		                       resultSetMetaData.getColumnCount());
//		    for (int colIdx = 0; colIdx < resultSetMetaData.getColumnCount();
//		                         colIdx++)
//		    {
//		      System.out.println("Column " + colIdx + ": type=" +
//		                         resultSetMetaData.getColumnTypeName(colIdx+1));
//		    }
		    // fetch data
//		    System.out.println("nData:");
//		    System.out.println("================================");
//		    int rowIdx = 0;
//		    while(resultSet.next())
//		    {
//		      System.out.println("row " + rowIdx + ", column 0: " +
//		                         resultSet.getString(1));
//		    }
//		    statement.close();
		  }
		  
	}
		   private static Connection getConnection() throws SQLException
		  {
		    try
		    {
		      Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
		    }
		    catch (ClassNotFoundException ex)
		    {
		     System.err.println("Driver not found");
		    }
		    // build connection properties
		    Properties properties = new Properties();
		    properties.put("user", "Ramakrishna");     //  username
		    properties.put("password", "Password$123"); // password
		    properties.put("account", "gw79119.central-india.azure");  //  your account name
		    properties.put("db", "DEMO_DB1");       // database name
		    properties.put("schema", "DEMO_SCHEMA");   // replace "" with target schema name
		    properties.put("role", "ACCOUNTADMIN");
		    //properties.put("tracing", "on");

		    // create a new connection
		   // String connectStr = System.getenv("SF_JDBC_CONNECT_STRING");
		    // use the default connection string if it is not set in environment
//		    if(connectStr == null)
//		    {
		    String connectStr = "jdbc:snowflake://gw79119.central-india.azure.snowflakecomputing.com"; // replace accountName with your account name
//		    }
		    return DriverManager.getConnection(connectStr, properties);
		  }
		
		
		

	}





