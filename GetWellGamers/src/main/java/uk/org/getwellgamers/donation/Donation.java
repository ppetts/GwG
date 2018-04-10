package uk.org.getwellgamers.donation;

import javax.persistence.*;

import uk.org.getwellgamers.hospitalstaff.HospitalStaff;

@Entity
public class Donation {

	@Id
	private String DonationID;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = HospitalStaff.class)
	@JoinColumn(name="PersonID")
	private HospitalStaff hospitalStaff;
	

	public Donation() {
		super();
	}



}