package uk.org.getwellgamers.staff;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class StaffDatabaseSeeder implements CommandLineRunner {

	//Generate the Hospital Data for the Database 
	private StaffRepositry staffResp;

	@Autowired
	public StaffDatabaseSeeder(StaffRepositry staffResp) {
		this.staffResp = staffResp;
	}

	@Override
	public void run(String... arg0) throws Exception {

		ArrayList<Staff> allStaff = new ArrayList<Staff>();

		Staff staff = new Staff();
		staff.setStaffId("001");
		staff.setAddress1("Harrock Hill View");
		staff.setAddress2("Bradshaw Lane");
		staff.setAddress3("Mawdesley");
		staff.setTown("Ormskirk");
		staff.setPostcode("L40 3SF");
		staff.setMobilenumber("07782505928");
		staff.setTelephonenumber("01704260510");
	
		allStaff.add(staff);
		
			
		staffResp.save(allStaff);
		
		System.out.println("Staff added :" + allStaff.size());
	}
}