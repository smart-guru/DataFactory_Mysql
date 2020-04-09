package dataTypes_Demo;

import java.util.Date;

import org.fluttercode.datafactory.impl.DataFactory;

public class RandomDates4 {
	
	public static void main(String[] args) {
		
		DataFactory df = new DataFactory();
	    Date minDate = df.getDate(2000, 1, 1);
	    Date maxDate = new Date();
    for (int i = 0; i < 10; i++) {
        //generate an order date
        Date orderDate = df.getDateBetween(minDate, maxDate);
     
        //estimate delivery 4-10 days after ordering
        Date estimatedDeliveryDate = df.getDate(orderDate, 4, 10);
     
        //deliver between 2 days prior and 3 days after delivery estimate
        Date actualDeliveryDate = df.getDate(estimatedDeliveryDate, -2, 3); 
     
        String msg =  "Ordered on "+dateToString(orderDate) +
            " deliver by = "+dateToString(estimatedDeliveryDate)+
            " delivered on " + dateToString(actualDeliveryDate);                    
     
        if (estimatedDeliveryDate.before(actualDeliveryDate)) {
            msg = msg + " - LATE";
        }
        if (estimatedDeliveryDate.after(actualDeliveryDate)) {
            msg = msg + " - EARLY";
        }
        System.out.println(msg);
    }

}
	private static Date dateToString(Date start) {
		// TODO Auto-generated method stub
		return start;
	}
}
