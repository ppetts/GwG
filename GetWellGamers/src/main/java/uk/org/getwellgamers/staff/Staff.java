package uk.org.getwellgamers.staff;

import javax.persistence.Entity;

import uk.org.getwellgamers.person.Person;

@Entity
public class Staff extends Person { //implements Comparable {

	private String address1;
	private String address2;
	private String address3;
	private String town;
	private String postcode;
	
	public Staff() {
		super();
	}
			
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}
