
package com.snowflake.setup;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import java.util.Properties;

import org.testng.annotations.BeforeMethod;

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
import org.testng.annotations.*;


public class Snowflake_DQL {
	@Test
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		 Properties properties = new java.util.Properties();
		    properties.put("user", "Ramakrishna");     //  username
		    properties.put("password", "Password$123"); // password
		    properties.put("account", "gw79119");  //  your account name
		    properties.put("db", "TEST_DB");       // database name
		    properties.put("schema", "TEST_SCHEMA");   // replace "" with target schema name
		    properties.put("role", "ACCOUNTADMIN");
		    
		    //jdbc URL
//		    String jdbcUrl="jdbc:snowflake://jbigvqk-yt00144.snowflakecomputing.com";
		    String jdbcUrl="jdbc:snowflake://gw79119.central-india.azure.snowflakecomputing.com";
		    
//		    // select query
//		    String selectSQL ="SELECT * FROM TEST_DB.TEST_SCHEMA.Employees";
		    
		    
		    
		    String sqlQuery1="create database TEST_DB" ;
		    String sqlQuery="create or replace table jdbc_demo01 ("+
		    		"id number,"+
		    		"name text)";
		    System.out.println("\t Starting the snowflake JDBC Connection Program");
		    //try catch
//		    try
//		    {
//		      Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
//		    }
//		    catch (ClassNotFoundException ex)
//		    {
//		     System.err.println("Driver not found");
//		    }
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
	    		
	                System.out.print("\t" + resultSet.getString("ID"));
	                System.out.print("\t" + resultSet.getString("NAME"));
//	                System.out.print("\t" + resultSet.getString(3));
//	                System.out.println("\t" + resultSet.getString(4));
	                }
	                
	    		 
//				    String selectSQL ="SELECT * FROM JDBC_DEMO01";
//				    stmt.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
//				    stmt.executeUpdate(selectSQL);
				   // System.out.println(selectSQL);
		    	 //execute update is for insert,update,delete DDL Statements
//		    	 
//		    	 int positiveInt1=stmt.executeUpdate(sqlQuery);
//		    	 System.out.println("\t Connection established,connection id:"+connection);
//		    	 System.out.println("\t Got the statement object,object-id:"+stmt);
//		    	 System.out.println("\t DDL statement executed:"+positiveInt);
//		    	 System.out.println("\t DDL statement executed:"+positiveInt1);
		    		
//		    	 String warehouseName="use warehouse MY_WH";
//	    		 int positiveInt3=stmt.executeUpdate(warehouseName);
//	    		 System.out.println("warehouse :"+positiveInt3);
//	    		 String database="use TEST_DB ";
//	    		 int positiveInt4=stmt.executeUpdate(database);
//	    		 System.out.println("database :"+positiveInt4);
//	    		 
	    		 	
	    		 	
//		    	 int insertRecord =13;
//		    	 for(int i=13;i<insertRecord;i++) {
//		    		 
//		    		 
////		    		 int positiveInt1=stmt.executeUpdate(sqlQuery);
//		    		 String dmlQuery="insert into jdbc_demo01 values ("+i+",'Name-"+i+"')";
//		    		 System.out.println("The Query is:"+dmlQuery);	
//		    		 int insertCnt=stmt.executeUpdate(dmlQuery);
//		    		 System.out.println("\t("+i+")Row Inserted:"+insertCnt);
//		    	}  
//		    	 
//		    	 
//		    	 	 String warehouseName="use warehouse MY_WH";
//		    	 	 stmt.executeUpdate(warehouseName);
//		    	 	 stmt.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
//		    		 ResultSet resultSet = stmt.executeQuery("SELECT * FROM jdbc_demo01");
//		    		 System.out.println(resultSet);
		    		 
		    	 
		    }catch (SQLException e) {
		    	
		    	System.out.println("Error Code = " + e.getErrorCode());
		    	System.out.println("SQL state = " + e.getSQLState());
		    	System.out.println("Message = " + e.getMessage());
		    	System.out.println("printTrace /n");
		    	e.printStackTrace();
		    	
		    	
		    }
	
		    	 
	}

}
//    ArrayList<ArrayList<String>>tblData=new ArrayList<ArrayList<String>>();
//		    String selectSQL="SELECT * FROM DEMO_DB.PUBLIC.EMPLOYEE_DETAILS";
//		    Statement stmt =conn.createStatement();
//		    ResultSet rsDDL=stmt.executeQuery(selectSQL);
//		    System.out.println(rsDDL);