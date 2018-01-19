package uk.org.getwellgamers.hospital;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	@Id
	String hospitalId;
	String name;
	String address1;
	String address2;
	String address3;
	String town;
	String county;
	String postcode;
	String telephone;
	
	public Hospital() {
		super();
	}

	
	public String getHospitalId() {
		return hospitalId;
	}


	public void setHospitalId(String id) {
		this.hospitalId = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getCounty() {
		return county;
	}


	public void setCounty(String county) {
		this.county = county;
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


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}