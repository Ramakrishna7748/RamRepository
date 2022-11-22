package com.snowflake.setup;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SnowflowDDL {

@Test
			public static void main(String[] args) throws SQLException, IOException {

			Properties prop =new Properties();
			FileInputStream fis;
			fis = new FileInputStream("./src/main/java/com/snowflake/config/properties");
			prop.load(fis);
			System.out.println(prop.getProperty("username"));
			System.out.println(prop.getProperty("password"));
//				public static void connection() throws SQLException {
					
				    Properties properties = new Properties();
				    properties.put("user", prop.getProperty("username"));     //  username
				    properties.put("password", prop.getProperty("password")); // password
				    properties.put("account", "jbigvqk-yt00144");  //  your account name
				    properties.put("db", "DEMO_DB");       // database name
				    properties.put("schema", "DEMO_SCHEMA");   // replace "" with target schema name
				    properties.put("role", "ACCOUNTADMIN");
				    //properties.put("tracing", "on");

				    // create a new co
				   // String connectStr = System.getenv("SF_JDBCnnection_CONNECT_STRING");
				    // use the default connection string if it is not set in environment
//				    if(connectStr == null)
//				    {
				  //  String connectStr = "jdbc:snowflake://gw79119.central-india.azure.snowflakecomputing.com";
				    String jdbcUrl="jdbc:snowflake://jbigvqk-yt00144.snowflakecomputing.com";
				    
				  //jdbc:snowflake://xy12345.snowflakecomputing.com/?user=demo&passcode=123456
		    
		   
		    try {
		    	// get connection
			    Connection conn = DriverManager.getConnection(jdbcUrl,properties);
		    	 Statement stmt =conn.createStatement();
		    	   // select query
		    	 stmt.executeUpdate("USE Database DEMO_DB") ;
		    	
//		    	 String warehouseName="use warehouse MY_WH";
		    	 stmt.executeUpdate("use warehouse MY_WH") ;
		    	
		
		    	
		    	 
		    	 
		    	 stmt.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
		    	 //Select Query
		    	 
		    	 ResultSet rs = stmt.executeQuery("SELECT e.ID,e.NAME,e.DOB,e.DOJ,e.DESIGNATION_ID,e.EMAIL,d.LEVEL from EMPLOYEE_DETAILS e  join designation_master d on d.id= e.id");
		 


		    	 while (rs.next()) 
		    	 {
		         Number ID = rs.getInt("ID");
		         String NAME=rs.getString("NAME");
		         Date DOB=rs.getDate("DOB");
		         Date DOJ=rs.getDate("DOJ");
		         Number DESIGNATION_ID=rs.getInt("DESIGNATION_ID");
		         String EMAIL=rs.getString("EMAIL");
		         String LEVEL=rs.getString("LEVEL");
		         
//		         Number Salary=rs.getInt("SALARY");
		         
		         System.out.println(ID+ ", "+NAME +
                         ", " + DOB + ", " + DESIGNATION_ID + ", " +EMAIL+ ", " +LEVEL );
////		          Beautification of output
//		         
//		         		                    System.out.format(
//		         
//		         		                        "%10s%10s%10s%10s%20s\n",
//		         
//		         		                       NAME, DOB, DESIGNATION_ID, EMAIL,LEVEL);
		         
		         		                }
		    	 

//		                while (rs.next()) {
//
//		                    String name = res.getString("Name");
//
//		                    String gender = res.getString("gender");
//
//		                    String caste = res.getString("caste");
//
//		                    String neetMarks
//
//		                        = res.getString("NeetMarks");
//
//		                    String email = res.getString("email");
//		 
//
//		                    // Beautification of output
//
//		                    System.out.format(
//
//		                        "%10s%10s%10s%10s%20s\n", name,
//
//		                        gender, caste, neetMarks, email);
//
//		                }
//		    	 while (rs.next()) 
//		    	 {
//		         
//		         String NAME=rs.getString("NAME");
////		         
////		         Date DOJ=rs.getDate("DOJ");
//		         String NAME1=rs.getString("NAME");
////		         Number TotalSalary=rs.getInt("totalsalary");
////		         Number DESIGNATION_ID=rs.getInt("DESIGNATION_ID");
//		     
//		         System.out.println( NAME + ", " + NAME );
//		         System.out.format("%10s%10s\n", NAME + ", " + NAME );
//		         
//		         JDBC connection string for user demo connecting to the xy12345 account (in the US West region) using a Duo passcode:


		         
		         
		         
		         
//		    	 		from employee_details e
//		    	 		inner join designation_master d on d.id= e.id
//		    	 		inner join payroll_master1 p on p.id=e.designation_id ");
		    	 
		    	 //Create Table

//		    	 stmt.executeUpdate("create or replace table Designation_Master  (" +"ID int,"+" NAME varchar(20),"+" LEVEL varchar(20) )");
//		    	 System.out.println("Designation_Master Table created");
		    	 
//				 
		    	 
//		    	 String sqlQuery="create or replace table jdbc_demo01 ("+
//				    		"id number,"+
//				    		"name text)"+
//		    		"Level)";
		    	 
		    	 //Insert values Into Table
//				 stmt.executeUpdate("insert into Designation_Master values (1,'Software engineer',1)");
//				 stmt.executeUpdate("insert into Designation_Master values (2,'manager',2)");
//				 stmt.executeUpdate("insert into Designation_Master values (3,'testing',3)");
//				 System.out.println("Inserted values into Designation_Master Table ");
				 
//				 stmt.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
//	    		 ResultSet resultSet = stmt.executeQuery("SELECT * FROM Designation_Master");
//	    		 System.out.println("select statement works");

	    		 
	    		 //	    		 ALTER TABLE EMPLOYEE_DETAILS
//	    		 ADD Address varchar(255);

//		    	 while (resultSet.next()) {
//		         int ID = resultSet.getInt("ID");
//		         String NAME=resultSet.getString("NAME");
//
//		         String LEVEL=resultSet.getString("LEVEL");
//
//		         System.out.println(ID + ", " + NAME + ", " + LEVEL);
//	    		 stmt.executeUpdate(" ALTER TABLE Designation_Master ADD PRIMARY KEY (ID)") ;
//	    		 System.out.println("Primary key added into existing Designation master table");
//		      }
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