package datafactory_connection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataWriteHw1 {
	public void WriteData(String filename, String Sheet, int row,int col,String data) throws IOException
	{
		FileInputStream fis1=new FileInputStream(filename);
		XSSFWorkbook wb=new XSSFWorkbook(fis1);
		XSSFSheet sheet=wb.getSheet(Sheet);
		XSSFRow rows=sheet.createRow(row);
		XSSFCell cols=rows.createCell(col);
		cols.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(filename);
		wb.write(fos);
	}

}
