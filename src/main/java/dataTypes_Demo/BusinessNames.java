package dataTypes_Demo;

import org.fluttercode.datafactory.impl.DataFactory;

public class BusinessNames {
	 public static void main(String[] args) {
	 DataFactory df = new DataFactory();
	    for (int i = 0; i < 1500; i++) {          
	        String address = df.getAddress()+","+df.getCity()+","+df.getNumberText(5);
	        String business = df.getBusinessName();
	        System.out.println(business + " located at " + address);
	    }
}
}  // can generate upto 1500 exact records.