package datafactory_connection;     //Db_connection

import java.sql.*;

import org.fluttercode.datafactory.impl.DataFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;

public class Db_connection {
	
	
	
	
	public static void main(String[] args) {

		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "gd";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		String f1, f2;
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			String query = "Select * FROM gd_cities";
			System.out.println("Connected to the database");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			Gson g=new Gson();
				 DataFactory df = new DataFactory();
		            for (int i = 0; i < 6799; i++) {          
		                String name = df.getFirstName() + " "+ df.getLastName();
		                System.out.println(name);

				}conn.close();
			
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
