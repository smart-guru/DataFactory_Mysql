package excelSamples;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SampleCode {
	 
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        new SampleCode().export();
    }
     
    public void export() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    	Scanner sc= new Scanner(System.in); //System.in is a standard input stream
    	System.out.print("Enter Limit ");
    	int a= sc.nextInt();
    	
    	System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "datafactory";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
//		String f1, f2;
		String excelFilePath = "Reviews-export1.xlsx";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			String query = "SELECT * FROM relevant_data ORDER BY RAND() LIMIT " + a;
			System.out.println("Connected to the database");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");
 
            writeHeaderLine(sheet);
 
            writeDataLines(result, workbook, sheet);
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
           
            stmt.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
 
    private void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("firstname");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("lastname");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("city");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("role");
 
//        headerCell = headerRow.createCell(4);
//        headerCell.setCellValue("Comment");
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            String courseName = result.getString("firstname");
            String studentName = result.getString("lastname");
            String rating = result.getString("city");
            String timestamp = result.getString("role");
//            String comment = result.getString("comment");
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(courseName);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(studentName);
 
            cell = row.createCell(columnCount++);
 
            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);
 
            cell.setCellValue(timestamp);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(rating);
 
//            cell = row.createCell(columnCount);
//            cell.setCellValue(comment);
 
        }
    }
 
}