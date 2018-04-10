package uk.org.getwellgamers.hospitalstaff;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import uk.org.getwellgamers.hospital.Hospital;
import uk.org.getwellgamers.hospital.HospitalService;
import uk.org.getwellgamers.person.Person;

@Order(3)
@Component
public class HospitalStaffDatabaseSeeder implements CommandLineRunner {

	//Generate the Donation Data for the Database 
	private HospitalStaffRepositry hospStaffResp;
	private HospitalService hospService;
	
	@Autowired
	public HospitalStaffDatabaseSeeder(HospitalStaffRepositry hospStaffResp, HospitalService hospService) {
		this.hospStaffResp = hospStaffResp;
		this.hospService = hospService;
	}

	@Override
	public void run(String... arg0) throws Exception {

		ArrayList<HospitalStaff> allHospStaff = new ArrayList<HospitalStaff>();

		HospitalStaff hospStaff = new HospitalStaff();
		
		Hospital hosp = hospService.getHospital("NTN41");
		if(null!=hosp) {
			hospStaff.setHospital(hosp);
		}
		
		hospStaff.setPersonId("hs001");
		hospStaff.setTitle(Person.TITLE.Dr);
		hospStaff.setForename("Holmes");
		hospStaff.setSurname("Sherlock");

		hospStaff.setMobilenumber("07876 133 461");
		hospStaff.setTelephonenumber("");
		allHospStaff.add(hospStaff);
		
		HospitalStaff hospStaff2 = new HospitalStaff();
		hospStaff2.setPersonId("hs002");
		hospStaff2.setTitle(Person.TITLE.Miss);
		hospStaff2.setForename("Sarah");
		hospStaff2.setSurname("Smith");
		hospStaff2.setMobilenumber("07782505928");
		hospStaff2.setTelephonenumber("01704260510");
		allHospStaff.add(hospStaff2);
							
		hospStaffResp.save(allHospStaff);
		
		System.out.println("Donation Staff added :" + allHospStaff.size());
	}
}