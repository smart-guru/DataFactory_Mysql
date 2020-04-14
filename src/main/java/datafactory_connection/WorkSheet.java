package datafactory_connection;

import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkSheet {

	public void WriteData(String filename, String Sheet, int row, int col, String data) throws IOException {
		// Creating Workbook instances
		Workbook wb = new XSSFWorkbook();
		// FileInputStream fis1=new FileInputStream(filename);

		XSSFWorkbook wb1 = new XSSFWorkbook();

//		XSSFSheet sheet = wb1.getSheet(Sheet);
		
		Sheet sheet1 = wb.createSheet(Sheet);

		
		XSSFRow rows = (XSSFRow) sheet1.createRow(row);
		XSSFCell cols = rows.createCell(col);
		cols.setCellValue(data);

		

//		FileOutputStream fos = new FileOutputStream(filename);
		OutputStream fileOut = new FileOutputStream(filename);
		wb1.write(fileOut);
	}
	// public static void main(String[] args) throws FileNotFoundException,
	// IOException
	// {
	//
	// // Creating Workbook instances
	// Workbook wb = new HSSFWorkbook();
	//
	// // An output stream accepts output bytes and sends them to sink.
	// OutputStream fileOut = new FileOutputStream("E:\\Geeks.xlsx");
	//
	// // Creating Sheets using sheet object
	// Sheet sheet1 = wb.createSheet("Array");
	//
	// System.out.println("Sheets Has been Created successfully");
	//
	// wb.write(fileOut);
	// writeData wd=new writeData(fileOut,sheet1,)
	// }
}
