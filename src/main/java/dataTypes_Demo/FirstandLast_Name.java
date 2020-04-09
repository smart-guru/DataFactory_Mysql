package dataTypes_Demo;

import org.fluttercode.datafactory.impl.DataFactory;

public class FirstandLast_Name {
	
	 
	        public static void main(String[] args) {
	            DataFactory df = new DataFactory();
	            for (int i = 0; i < 6799; i++) {          
	                String name = df.getFirstName() + " "+ df.getLastName();
	                System.out.println(name);
	            }
	        }
	    }  // can generate upto 6799 exact records
