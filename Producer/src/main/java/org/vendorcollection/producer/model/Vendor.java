package org.vendorcollection.producer.model;

import org.springframework.stereotype.Component;

@Component
public class Vendor {
private String vendorname;
private String firstName;
private String lastName;
private String city;
private String zipcode;
private String phonenumber;
public String getVendorname() {
	return vendorname;
}
public void setVendorname(String vendorname) {
	this.vendorname = vendorname;
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
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getZipcode() {
	return zipcode;
}
public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
@Override
public String toString() {
	return "Vendor [vendorname=" + getVendorname() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", city=" + getCity()
			+ ", zipcode=" + getZipcode() + ", phonenumber=" + getPhonenumber() + "]";
}

}
