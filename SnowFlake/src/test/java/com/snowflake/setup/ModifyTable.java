package com.snowflake.setup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModifyTable {

@BeforeMethod
@Test

			public static void main(String[] args) throws SQLException {
//				public static void connection() throws SQLException {
					
				    Properties properties = new Properties();
				    properties.put("user", "Ramakrishna");     //  username
				    properties.put("password", "Password$123"); // password
				    properties.put("account", "jbigvqk-yt00144");  //  your account name
				    properties.put("db", "DEMO_DB");       // database name
				    properties.put("schema", "MYSCHEMA");   // replace "" with target schema name
				    properties.put("role", "ACCOUNTADMIN");
				    //properties.put("tracing", "on");

				    // create a new connection
				   // String connectStr = System.getenv("SF_JDBC_CONNECT_STRING");
				    // use the default connection string if it is not set in environment
//				    if(connectStr == null)
//				    {
				    String connectStr = "jdbc:snowflake://gw79119.central-india.azure.snowflakecomputing.com";
				    String jdbcUrl="jdbc:snowflake://jbigvqk-yt00144.snowflakecomputing.com";
				    

		    
		   
		    try {
		    	// get connection
			    Connection conn = DriverManager.getConnection(jdbcUrl,properties);
		    	 Statement stmt =conn.createStatement();
		    	   // select query
		    	 stmt.executeUpdate("USE Database DEMO_DB") ;
		    	 System.out.println("Use db works");
//		    	 String warehouseName="use warehouse MY_WH";
		    	 stmt.executeUpdate("use warehouse MY_WH") ;
		    	
		    	 System.out.println("Use warehouse works");
		    	 //stmt.executeUpdate("") ;
		    	 stmt.executeUpdate("ALTER TABLE Orders	  add foreign key (id) references designation_master(id);") ;
		    	 System.out.println("Foreign key added");
		    	 
		    	 String query = "SELECT ID,NAME,DOB,DOJ,DESIGNATION_ID,EMAIL,PASSWORD from EMPLOYEE_DETAILS";
		    	 stmt.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
		    	 ResultSet rs =  stmt.executeQuery(query);
		    	 
		    	 System.out.println("query executed works");
		    	 while (rs.next()) 
		    	 {
		         Number ID = rs.getInt("ID");
		         String NAME=rs.getString("NAME");
		         Date DOB=rs.getDate("DOB");
		         Date DOJ=rs.getDate("DOJ");
		         Number DESIGNATION_ID=rs.getInt("DESIGNATION_ID");
		         String EMAIL=rs.getString("EMAIL");
		         String PASSWORD=rs.getString("PASSWORD");
		         System.out.println(ID + ", " + NAME +
                         ", " + DOB + ", " + DESIGNATION_ID + ", " +EMAIL+ ", " +PASSWORD
                         );
		    	 }
		         ResultSet resultSet = stmt.executeQuery("SELECT * FROM Designation_Master");
		         while (resultSet.next()) 
		         {
			     int ID = resultSet.getInt("ID");
			     String NAME=resultSet.getString("NAME");
			     String LEVEL=resultSet.getString("LEVEL");
			     System.out.println(ID + ", " + NAME + ", " + LEVEL);
		         }
		    }
		    	  
		    	catch (SQLException e) {
		    	System.out.println("Error Code = " + e.getErrorCode());
		    	System.out.println("SQL state = " + e.getSQLState());
		    	System.out.println("Message = " + e.getMessage());
		    	System.out.println("printTrace /n");
		    	e.printStackTrace();
		    	
		    	
		    }
		  }
		
}