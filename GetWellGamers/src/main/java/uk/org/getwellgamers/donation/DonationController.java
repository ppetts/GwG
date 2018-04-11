package uk.org.getwellgamers.donation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonationController {

	@Autowired
	DonationService donationService;

	@RequestMapping("/donation")
	public List<Donation> getAllDonations() {
		return donationService.getAllDonations();
	}

	@RequestMapping("/donation/{id}")
	public Donation getDonation(@PathVariable String id) {
		return donationService.getDonation(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/donation/{id}")
	public Donation addDonation(@RequestBody Donation donation) {
		donationService.addDonation(donation);
		return donation;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/donation/{id}")
	public void deleteDonation(@RequestBody Donation donation) {
		donationService.deleteDonation(donation);
	}
}