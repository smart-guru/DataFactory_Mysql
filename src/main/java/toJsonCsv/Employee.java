package toJsonCsv;

import java.util.Date;
import java.util.List;

public class Employee
{
   private Integer id;
   private String firstName;
   private String lastName;
   private String City_Name;
   private String Street_Name;
   private String Business;
public Integer getId() {
	return id;
}
public String getCity_Name() {
	return City_Name;
}
public void setCity_Name(String city_Name) {
	City_Name = city_Name;
}
public String getStreet_Name() {
	return Street_Name;
}
public void setStreet_Name(String street_Name) {
	Street_Name = street_Name;
}
public String getBusiness() {
	return Business;
}
public void setBusiness(String f5) {
	Business = f5;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

    
@Override
public String toString() 
{ 
	return "Employee [firstName=" + firstName + ", " +
            "lastName=" + lastName + ", "+ "City Name=" + City_Name +", "+" Street_Name=" + Street_Name + ","+""
            		+ "Business="+ Business+"]"; 
}
}