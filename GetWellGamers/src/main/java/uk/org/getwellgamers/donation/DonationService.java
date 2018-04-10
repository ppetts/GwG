package uk.org.getwellgamers.donation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

	@Autowired
	private DonationRepositry donationRep;

	public List<Donation> getAllDonations() {
		List<Donation> allDonations = new ArrayList<Donation>();
		donationRep.findAll().forEach(allDonations::add);
		return allDonations;
	}

	public Donation getDonation(String id) {
		System.out.println("getDonation:" + id);
		return donationRep.findOne(id);
	}

	public void updateDonation(Donation hosp) {
		donationRep.save(hosp);
	}

	public void deleteDonation(Donation hosp) {
		donationRep.delete(hosp);
	}

	public void addDonation(Donation hosp) {
		donationRep.save(hosp);
	}
}