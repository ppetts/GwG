package uk.org.getwellgamers.donation;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import uk.org.getwellgamers.person.Person;

@Order(1)
@Component
public class DonationDatabaseSeeder implements CommandLineRunner {

	//Generate the Donation Data for the Database 
	private DonationRepositry DonationResp;

	@Autowired
	public DonationDatabaseSeeder(DonationRepositry DonationResp) {
		this.DonationResp = DonationResp;
	}

	@Override
	public void run(String... arg0) throws Exception {

		ArrayList<Donation> allDonation = new ArrayList<Donation>();

		Donation Donation = new Donation();

		allDonation.add(Donation);
		
		Donation Donation2 = new Donation();

		allDonation.add(Donation2);
					
		DonationResp.save(allDonation);
		
		System.out.println("Donation(s) added :" + allDonation.size());
	}
}