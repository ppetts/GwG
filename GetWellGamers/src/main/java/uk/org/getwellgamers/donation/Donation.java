package uk.org.getwellgamers.donation;

import javax.persistence.*;

import uk.org.getwellgamers.hospitalstaff.HospitalStaff;

@Entity
public class Donation {

	@Id
	private String DonationID;

//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = HospitalStaff.class)
//	@JoinColumn(name="PersonID")
	@Embedded
	private HospitalStaff hospitalStaff;

	public Donation() {
		super();
	}

	public String getDonationID() {
		 return DonationID;
	}

	public void setDonationID(String donationID) {
		DonationID = donationID;
	}

	public HospitalStaff getHospitalStaff() {
		return hospitalStaff;
	}

	public void setHospitalStaff(HospitalStaff hospitalStaff) {
		this.hospitalStaff = hospitalStaff;
	}
}