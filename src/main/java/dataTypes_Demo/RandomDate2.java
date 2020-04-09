package dataTypes_Demo;

import java.util.Date;

import org.fluttercode.datafactory.impl.DataFactory;

public class RandomDate2 {  //this is random date between 1/1/2000 to current date
	public static void main(String[] args) {
    DataFactory df = new DataFactory();
    Date minDate = df.getDate(2000, 1, 1);
    Date maxDate = new Date();
         
    for (int i = 0; i <=1400; i++) {
        Date start = df.getDateBetween(minDate, maxDate);
        Date end = df.getDateBetween(start, maxDate);
        System.out.println("Date range = " + dateToString(start) + " to " + dateToString(end));
    }

}

	private static Date dateToString(Date start) {
		// TODO Auto-generated method stub
		return start;
	}
}
