package tojsonCsvConvertion;


import java.io.*;
import java.sql.*;
 

public class ToCsv {
 
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
      
        System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "datafactory";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		 String csvFilePath = "Reviews-export.csv";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			String query = "Select * FROM relevant_data";
			System.out.println("Connected to the database");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
           
   
             
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
             
            // write header line containing column names       
//            fileWriter.write("city_id,county_slug,region_slud,city");
            fileWriter.write("firstname,lastname,city,role"); 
            while (rs.next()) {
//                String city_id = rs.getString("city_id");
//                String country_slug = rs.getString("country_slug");
//                String region_slug = rs.getString("region_slug");
//                String city = rs.getString("city");

            	 String firstname = rs.getString("firstname");
                 String lastname = rs.getString("lastname");
                 String city = rs.getString("city");
                 String role = rs.getString("role");
                 
//                if (comment == null) {
//                    comment = "";   // write empty value for null
//                } else {
//                    comment = "\"" + comment + "\""; // escape double quotes
//                }
//                 
                String line = String.format("%1$s, %2$s , %3$s, %4$s",
                		firstname, lastname, city, role);
                
                fileWriter.newLine();
                fileWriter.write(line);     
                System.out.println(line);
            }
             
            statement.close();
            fileWriter.close();
             
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
         
    }
 
}