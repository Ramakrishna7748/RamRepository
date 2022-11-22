package com.Snowflake.csv;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.testng.annotations.Test;  
public class Compare  
{  
	// Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the background color
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\\u001B[42m";
    
	public static void main(String[] args)
	{
//		List<String> csvData=readCsvData();
//		List<String> dbData = readDbData();
//		  csvData.equals(dbData);
		  areCsvDataSameAsDb();
	}
//		//parsing a CSV file into Scanner class constructor  
//		Scanner sc = new Scanner(new File("C:\\Users\\mramak\\Desktop\\EMPLOYEE_DETAILS2.csv"));  
//		sc.useDelimiter(",");   //sets the delimiter pattern  
//		while (sc.hasNext())  //returns a boolean value  
//		{  
//		
//			System.out.print(sc.next());  //find and returns the next complete token from this scanner  
//		}   
//	}
	
	public static ArrayList<String> readCsvData() {
	    ArrayList<String> csvData = new ArrayList<>();
	    
	    
	    // use try-with-resources to auto close reader
	    try (BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\mramak\\Desktop\\EMPLOYEE_DETAILS2.csv"))){
	        String row;
	        while ((row = csvReader.readLine()) != null) {
	            String[] data = row.split(",");
	            row = String.join("\t",data[0], data[1], data[2],data[3],data[4],data[5],data[6]);
	            System.out.println(row);
	            csvData.add(row);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
		return csvData;
	    

	}

	
	
	public static void initDb() {
		try
	    {
	      Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
	    }
	    catch (ClassNotFoundException ex)
	    {
	     System.err.println("Driver not found");
	    }
	}
	@Test
	public static ArrayList<String> readDbData(){
	    initDb();
	    
//	    String url = "jdbc:snowflake://jbigvqk-yt00144.snowflakecomputing.com";
//	    String user = "Ramakrishna";
//	    String password = "Password$123";
//	    String sql = "SELECT * FROM Employee_details";
	    Properties properties = new java.util.Properties();
	    properties.put("user", "Ramakrishna");     //  username
	    properties.put("password", "Password$123"); // password
	    properties.put("account", "jbigvqk-yt00144");  //  your account name
	    properties.put("db", "DEMO_DB");       // database name
	    properties.put("schema", "MY_SCHEMA");   // replace "" with target schema name
	    properties.put("role", "ACCOUNTADMIN");
	    
	    //jdbc URL
	    String jdbcUrl="jdbc:snowflake://jbigvqk-yt00144.snowflakecomputing.com";
	    
	    
	    ArrayList<String> dbData = new ArrayList<>();

	    // use try-with-resources to auto close SQL connection, etc.
//	    try (Connection conn = DriverManager.getConnection(url, user, password);
//	         Statement st = conn.createStatement();
//	         ResultSet rs = st.executeQuery(sql);
//	    ) {
//	        while (rs.next()) {
//	            String row = String.join("\t", rs.getString(1), rs.getString(2), rs.getString(3));
//	            System.out.println(row);
//	            dbData.add(row);
//	        }
//	    } catch (Exception exc) {
//	        exc.printStackTrace();
//	        throw new RuntimeException(exc);
//	    }
//	    return dbData;
	    
	    
	    try {
	    	 Connection connection = DriverManager.getConnection(jdbcUrl,properties);
	    	 Statement stmt =connection.createStatement();
	    	   // select query
	    	 String warehouseName="use warehouse MY_WH";
	   		 stmt.executeUpdate(warehouseName);
	//   		 System.out.println("warehouse :"+positiveInt3);
	   		 String database="use DEMO_DB ";
	   		 stmt.executeUpdate(database);
	//   		 System.out.println("database :"+positiveInt4);
	   		 String query = "SELECT ID,NAME,DOB,DOJ,DESIGNATION_ID,EMAIL,PASSWORD from EMPLOYEE_DETAILS";
	    	 stmt.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
	    	 ResultSet rs =  stmt.executeQuery(query);

	    	 while (rs.next()) 
	    	 {
	    		 
		    	 String row = String.join("\t", rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
	             System.out.println(row);
	             dbData.add(row);
	             
//	         Number ID = rs.getInt("ID");
//	         String NAME=rs.getString("NAME");
//	         Date DOB=rs.getDate("DOB");
//	         Date DOJ=rs.getDate("DOJ");
//	         Number DESIGNATION_ID=rs.getInt("DESIGNATION_ID");
//	         String EMAIL=rs.getString("EMAIL");
//	         String PASSWORD=rs.getString("PASSWORD");
////	         System.out.println(ID  + NAME + DOB +  DESIGNATION_ID + EMAIL+ PASSWORD);
//	         System.out.println(ID + "       " + NAME +
//	                 "       " + DOB + "       " + DESIGNATION_ID + "       " +EMAIL+ "       " +PASSWORD);
		    }
		    }
    	 catch (SQLException e) {
	    	
	    	System.out.println("Error Code = " + e.getErrorCode());
	    	System.out.println("SQL state = " + e.getSQLState());
	    	System.out.println("Message = " + e.getMessage());
	    	System.out.println("printTrace /n");
	    	e.printStackTrace();
	    	
	    	
	    }
	    return dbData;
	}
	
	public static boolean areCsvDataSameAsDb() {
		
		ArrayList<String> csvData = readCsvData();
		ArrayList<String> dbData = readDbData();
	    boolean equalLists = csvData.equals(dbData);
	    System.out.println("Status:   "+equalLists);
	    
//	    if (csvData.equals(dbData)==false)
//	    {
//	
//	    	 areCsvDataSameAsDb();
//	    	 System.out.println(ANSI_RED_BACKGROUND);
//	    }
//	    else
//	    	
//	    	System.out.println(ANSI_GREEN_BACKGROUND);
	    
	   
	    		 
//	    
	    
//	    String[] row1 = new String[10];
//        String[] row2 = new String[10];
	    Object[] objects = csvData.toArray();
	    Object[] objects2 = dbData.toArray();
	    for(int i=0;i<objects.length;i++)
	    {
	    	if(objects[i].equals(objects2[i]))
	    	{
	    		
	    	System.out.println(ANSI_GREEN + "Row No" +i+ "Matched");
	    	}
	    	else
//	    	System.out.println(objects[i]);
//	    	final String ANSI_YELLOW = "\u001B[33m";
	    	System.out.println(ANSI_RED +"Row No" +i+ "Not Matched:   "+objects[i] +ANSI_RESET);
	    		
	    }
//	    System.out.println(objects[1]);
//	    System.out.println(objects2[1]);
	    
//	    	if(objects.length== objects2)
//            System.out.print(obj + " ");
//	    
//	    
//	    for (int i = 0; i < ((String) objects[0]).length(); i++ ) {
//            for (int j = 0; j < ((String) objects2[1]).length(); j++){
//            	  System.out.println("objects");
//                    
////                        row1[i] = fruit[0][i];
////                        row2[j] = fruit[1][j];
//
//                        System.out.println("Match found");
//                        System.out.println(objects);
//                        
//                    }else{
//                        System.out.println("Not found"+i+j);
//                    }
//            }
//	    }
	    
	    
	    
	    
	    
	    
	    
	    
//	    boolean equalLists = csvData.size() == dbData.size() && csvData.containsAll(dbData);
//	    System.out.println(equalLists);
//	    for (String csvData1 : csvData) 
//   	   {
//	    
//	    	 System.out.println(csvData1);
//   	   }
	   
	    	 
	    	 
	    	 
	   
	    return csvData.equals(dbData);
	    
//		return equalLists;
	}
}