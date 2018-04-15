package uk.org.getwellgamers.stock;

import javax.persistence.*;

import uk.org.getwellgamers.donation.Donation;
import uk.org.getwellgamers.hospital.Hospital;
import uk.org.getwellgamers.staff.Staff;

@Entity
public class Stock {
	
	@Id   //   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String stockId;
	private String brand;
	private String model;
	private String notes;
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Donation.class)
	@JoinColumn(name="DonationID")
	private Donation donation;
		
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Hospital.class)
	@JoinColumn(name="OrganisationID")
	private Hospital hospital;
		
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Staff.class)
	@JoinColumn(name="StaffID")
	private Staff staff;
	
	
	public Stock() {
		super();
	}


	public String getStockId() {
		return stockId;
	}


	public void setStockId(String stockId) {
		this.stockId = stockId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Hospital getHospital() {
		return hospital;
	}


	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}


	public Donation getDonation() {
		return donation;
	}


	public void setDonation(Donation donation) {
		this.donation = donation;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}