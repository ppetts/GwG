package uk.org.getwellgamers.donation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import uk.org.getwellgamers.hospital.HospitalService;
import uk.org.getwellgamers.hospitalstaff.HospitalStaff;
import uk.org.getwellgamers.hospitalstaff.HospitalStaffRepositry;
import uk.org.getwellgamers.hospitalstaff.HospitalStaffService;

@Order(1)
@Component
public class DonationDatabaseSeeder implements CommandLineRunner {

	//Generate the Donation Data for the Database 
	private DonationRepositry DonationResp;
	private HospitalStaffService hospStaffService;

	@Autowired
	public DonationDatabaseSeeder(DonationRepositry DonationResp, HospitalStaffService hospStaffService) {
		this.DonationResp = DonationResp;
		this.hospStaffService = hospStaffService;
	}
	

	@Override
	public void run(String... arg0) throws Exception {

		ArrayList<Donation> allDonation = new ArrayList<Donation>();

		Donation donation = new Donation();
		donation.setDonationID("D000001");
		
		HospitalStaff hospStaff = hospStaffService.getStaff("hs001");
		if(null == hospStaff) {
			System.err.println("Staff null : hs001");
		}
		donation.setHospitalStaff(hospStaff);
		allDonation.add(donation);
//		
//		Donation donation2 = new Donation();
//
//		allDonation.add(donation2);
					
		DonationResp.save(allDonation);
		
		System.out.println("Donation(s) added :" + allDonation.size());
	}
}