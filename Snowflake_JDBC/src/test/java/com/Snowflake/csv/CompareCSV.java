package com.Snowflake.csv;
import java.io.FileReader;  
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;  
public class CompareCSV   
{    
	@Test
	public static void ReadCsv()
	{  
	CSVReader reader = null;  
		try  
		{  
			reader = new CSVReader(new FileReader("C:\\Users\\mramak\\Desktop\\EMPLOYEE_DETAILS2.csv"));    
			String [] nextLine;  
			//read one line at a time  
			while ((nextLine = reader.readNext()) != null)  
				{  
				for(String token : nextLine)  
					{  
						System.out.println(token);  
					}  
						System.out.print("\n");  
				}  
		}  
		catch (Exception e)   
		{  
			e.printStackTrace();  
		}  
	} 
	@Test
	public static void connection() {
		
			
			// TODO Auto-generated method stub
		 	Properties properties = new java.util.Properties();
		    properties.put("user", "Ramakrishna");     //  username
		    properties.put("password", "Password$123"); // password
		    properties.put("account", "jbigvqk-yt00144");  //  your account name
		    properties.put("db", "TEST_DB");       // database name
		    properties.put("schema", "TEST_SCHEMA");   // replace "" with target schema name
		    properties.put("role", "ACCOUNTADMIN");
		    
		    //jdbc URL
		    String jdbcUrl="jdbc:snowflake://jbigvqk-yt00144.snowflakecomputing.com";
		    
		    
//		    // select query
//		    String selectSQL ="SELECT * FROM TEST_DB.TEST_SCHEMA.Employees";
		    
		    
		    
		    String sqlQuery1="create database TEST_DB" ;
		    String sqlQuery="create or replace table jdbc_demo01 ("+
		    		"id number,"+
		    		"name text)";
		    System.out.println("\t Starting the snowflake JDBC Connection Program");
		    //try catch
		    try
		    {
		      Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
		    }
		    catch (ClassNotFoundException ex)
		    {
		     System.err.println("Driver not found");
		    }
		    try {
		    	 Connection connection = DriverManager.getConnection(jdbcUrl,properties);
		    	 Statement stmt =connection.createStatement();
		    	   // select query
		    	 String warehouseName="use warehouse MY_WH";
	    		 int positiveInt3=stmt.executeUpdate(warehouseName);
	    		 System.out.println("warehouse :"+positiveInt3);
	    		 String database="use TEST_DB ";
	    		 int positiveInt4=stmt.executeUpdate(database);
	    		 System.out.println("database :"+positiveInt4);
	    		 	stmt.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
	    		 	ResultSet resultSet = stmt.executeQuery("SELECT * FROM jdbc_demo01");
	    		 	
	    		 	while (resultSet.next())
	                {
	    		 	   Number ID = resultSet.getInt("ID");
	    		 	   String NAME=resultSet.getString("NAME");
	                
	    		 	   System.out.println(ID+ ", "+ NAME );
	    		 	 
		    	 
		    }
	    		 	
		    }catch (SQLException e) {
		    	
		    	System.out.println("Error Code = " + e.getErrorCode());
		    	System.out.println("SQL state = " + e.getSQLState());
		    	System.out.println("Message = " + e.getMessage());
		    	System.out.println("printTrace /n");
		    	e.printStackTrace();
		    	
		    	
		    }
	}  
}