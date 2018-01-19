package uk.org.getwellgamers.hospitalstaff;

import uk.org.getwellgamers.hospital.Hospital;
import uk.org.getwellgamers.person.Person;

public class HospitalStaff extends Person {

	private Hospital hospital;
	
	public HospitalStaff() {
		super();
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	
	
	
}
