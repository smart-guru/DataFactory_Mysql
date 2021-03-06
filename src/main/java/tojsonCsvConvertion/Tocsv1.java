package tojsonCsvConvertion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tocsv1 {
    private BufferedWriter fileWriter;
     
    public void export(String table) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	  System.out.println("MySQL Connect Example.");
  		Connection conn = null;
  		String url = "jdbc:mysql://localhost:3306/";
  		String dbName = "datafactory";
  		String driver = "com.mysql.jdbc.Driver";
  		String userName = "root";
  		String password = "";
  		String csvFileName = getFileName(table.concat("_Export"));
  		try {
  			Class.forName(driver).newInstance();
  			conn = DriverManager.getConnection(url + dbName, userName, password);
  			String query = "Select * FROM relevant_data";
  			System.out.println("Connected to the database");
  			Statement statement = conn.createStatement();
  			ResultSet rs = statement.executeQuery(query);
             
            fileWriter = new BufferedWriter(new FileWriter(csvFileName));
             
            int columnCount = writeHeaderLine(rs);
             
            while (rs.next()) {
                String line = "";
                 
                for (int i = 2; i <= columnCount; i++) {
                    Object valueObject = rs.getObject(i);
                    String valueString = "";
                     
                    if (valueObject != null) valueString = valueObject.toString();
                     
                    if (valueObject instanceof String) {
                        valueString = "\"" + escapeDoubleQuotes(valueString) + "\"";
                    }
                     
                    line = line.concat(valueString);
                     
                    if (i != columnCount) {
                        line = line.concat(",");
                    }
                }
                 
                fileWriter.newLine();
                fileWriter.write(line);            
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
 
    private String getFileName(String baseName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("_%s.csv", dateTimeInfo));
    }
     
    private int writeHeaderLine(ResultSet result) throws SQLException, IOException {
        // write header line containing column names
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
        String headerLine = "";
         
        // exclude the first column which is the ID field
        for (int i = 2; i <= numberOfColumns; i++) {
            String columnName = metaData.getColumnName(i);
            headerLine = headerLine.concat(columnName).concat(",");
        }
         
        fileWriter.write(headerLine.substring(0, headerLine.length() - 1));
         
        return numberOfColumns;
    }
     
    private String escapeDoubleQuotes(String value) {
        return value.replaceAll("\"", "\"\"");
    }
     
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Tocsv1 exporter = new Tocsv1();
        exporter.export("review");
        exporter.export("product");
    }  
}