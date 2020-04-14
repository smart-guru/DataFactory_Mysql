package datafactory_connection;

import java.util.Scanner;
import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.fluttercode.datafactory.impl.DataFactory;

public class FirstNameGenerateData {

	Scanner sc = new Scanner(System.in);
	int rowno = 0;
	int colno = 0;

	public void generateData() throws IOException {
		System.out.println("How many row/column of data do you want to print");
		int rowcolData = sc.nextInt();

		DataFactory df = new DataFactory();

		for (int i = 0; i < rowcolData; i++) {
			String name = df.getFirstName();
			String name1 = df.getLastName();
			System.out.println(name);
			
			// ExcelDataWriteHw1 obj=new ExcelDataWriteHw1();
			// obj.WriteData("fileOut", "sheet1", rowno++,colno,name);

			WorkSheet ws = new WorkSheet();
			ws.WriteData("E://Data1.xlsx", "Array", rowno++, colno, name);

		}
	}

	public static void main(String[] args) throws IOException {
		FirstNameGenerateData fname = new FirstNameGenerateData();
		fname.generateData();

	}

}
