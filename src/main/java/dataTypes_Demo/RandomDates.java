package dataTypes_Demo;

import java.util.Date;

import org.fluttercode.datafactory.impl.DataFactory;

public class RandomDates {
	public static void main(String[] args) {
	  DataFactory df = new DataFactory();
	    Date minDate = df.getDate(2000, 1, 1);
	    Date maxDate = new Date();
	    for (int i = 0; i < 2600; i++) {
	        Date start = df.getDateBetween(minDate, maxDate);
	        System.out.println("Date = "+start);
	    }

}
}
