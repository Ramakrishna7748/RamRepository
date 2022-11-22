package com.Snowflake.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Compare2{
	@Test
public static List<String> readCsvData() {
    List<String> csvData = new ArrayList<>();
    // use try-with-resources to auto close reader
    try (BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\mramak\\Desktop\\EMPLOYEE_DETAILS2.csv"))){
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            row = String.join("\t", data[0], data[1], data[2]);
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
    try {
        Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

public static List<String> readDbData(){
    initDb();
    String url = "jdbc:snowflake://jbigvqk-yt00144.snowflakecomputing.com";
    String user = "Ramakrishna";
    String password = "Password$123";
    String sql = "SELECT * FROM Employee_details";
    List<String> dbData = new ArrayList<>();

    // use try-with-resources to auto close SQL connection, etc.
    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql);
    ) {
        while (rs.next()) {
            String row = String.join("\t", rs.getString(1), rs.getString(2), rs.getString(3));
            System.out.println(row);
            dbData.add(row);
        }
    } catch (Exception exc) {
        exc.printStackTrace();
        throw new RuntimeException(exc);
    }
    return dbData;
}

public static boolean areCsvDataSameAsDb() {
    List<String> csvData = readCsvData();
    List<String> dbData = readDbData();
    
    return csvData.equals(dbData);
}
}