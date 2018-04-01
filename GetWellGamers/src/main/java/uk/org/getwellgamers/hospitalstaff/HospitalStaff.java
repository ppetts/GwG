package uk.org.getwellgamers.hospitalstaff;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import uk.org.getwellgamers.hospital.Hospital;
import uk.org.getwellgamers.person.Person;

@Entity
public class HospitalStaff extends Person {

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Hospital.class)
	@JoinColumn(name="OrganisationID")
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