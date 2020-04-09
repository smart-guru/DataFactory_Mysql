package dataTypes_Demo;

import java.util.Date;

import org.fluttercode.datafactory.impl.DataFactory;

public class RandomDates3 {
	
	public static void main(String[] args) {
		
		DataFactory df = new DataFactory();
	    Date minDate = df.getDate(2000, 1, 1);
	    Date maxDate = new Date();
	    
	for (int i = 0; i < 10; i++) {
	    Date start = df.getDateBetween(minDate, maxDate);
	    Date end = df.getDate(start, 1, 10); //set end to within 10 days of the start
	    System.out.println("Date range = " + dateToString(start) + " to " + dateToString(end));
	}

}
	
	private static Date dateToString(Date start) {
		// TODO Auto-generated method stub
		return start;
	}
	
}