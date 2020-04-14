package tojsonCsvConvertion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Arrays;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import toJsonCsv.Employee;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

public class UsingGson {
	public static void main(String[] args) {
		
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "datafactory";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		String f1, f2 ,f3, f4;
		String f5;
		String jsonFilePath="json-export.xml";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			String query = "Select * FROM relevant_data";
			System.out.println("Connected to the database");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(jsonFilePath));
			 Employee employee = new Employee();
			while (rs.next()) {
				f1 = rs.getString(1);
				f2 = rs.getString(2);
				f3 = rs.getString(3);
				f4 = rs.getString(4);
//				f5 = rs.getString(5);
				
				
				 employee.setFirstName(f1);
				 employee.setLastName(f2);
				 employee.setCity_Name(f3);
				 employee.setStreet_Name(f4);
//				 employee.setBusiness(f5);
				 
//				 Gson gson = new Gson();
//					System.out.println(gson.toJson(employee));
//				 Gson gson = new GsonBuilder()
//			             .disableHtmlEscaping()
//			             .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//			             .setPrettyPrinting()
//			             .serializeNulls()
//			             .create();
				 Gson gson = new GsonBuilder().setPrettyPrinting().create();
					 String jsonOutput = gson.toJson(employee);
				System.out.println(jsonOutput);
			} // end while
		
			conn.close();
			System.out.println("Disconnected from database");
		} // end try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
			// Employee employee = new Employee();
			// employee.setId(1);
			// employee.setFirstName(rs.getString(2));
			// employee.setLastName(rs.getString(3));
			// employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));
			//
			// Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// String jsonOutput = gson.toJson(employee);


