package uk.org.getwellgamers.staff;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import uk.org.getwellgamers.person.Person;

@Order(1)
@Component
public class StaffDatabaseSeeder implements CommandLineRunner {

	//Generate the Staff Data for the Database 
	private StaffRepository staffResp;

	@Autowired
	public StaffDatabaseSeeder(StaffRepository staffResp) {
		this.staffResp = staffResp;
	}

	@Override
	public void run(String... arg0) throws Exception {

		ArrayList<Staff> allStaff = new ArrayList<Staff>();

		Staff staff = new Staff();
		staff.setPersonId("001");
		staff.setTitle(Person.TITLE.Mr);
		staff.setForename("James");
		staff.setSurname("Stewart");
		staff.setAddress1("4 2/1 Glencairn Drive");
		staff.setAddress2("");
		staff.setAddress3("");
		staff.setTown("Glasgow");
		staff.setPostcode("G41 4QN");
		staff.setMobilenumber("07876 133 461");
		staff.setTelephonenumber("");
		allStaff.add(staff);
		
		Staff staff2 = new Staff();
		staff2.setPersonId("002");
		staff2.setPrincipalId("109079109643704089762");
		staff2.setTitle(Person.TITLE.Mr);
		staff2.setForename("Phil");
		staff2.setSurname("Petts");
		staff2.setAddress1("Harrock Hill View");
		staff2.setAddress2("Bradshaw Lane");
		staff2.setAddress3("Mawdesley");
		staff2.setTown("Ormskirk");
		staff2.setPostcode("L40 3SF");
		staff2.setMobilenumber("07782505928");
		staff2.setTelephonenumber("01704260510");
		allStaff.add(staff2);
		
		Staff staff3 = new Staff();
		staff3.setPersonId("003");
		staff3.setTitle(Person.TITLE.Mr);
		staff3.setForename("Homer");
		staff3.setSurname("Simpson");
		staff3.setAddress1("23 Firs Road");
		staff3.setAddress2("Milnthorpe");
		staff3.setAddress3("Cumbria");
		staff3.setTown("");
		staff3.setPostcode("LA7 7QQ");
		staff3.setMobilenumber("");
		staff3.setTelephonenumber("0153931234");
		allStaff.add(staff3);
		
		Staff staff4 = new Staff();
		staff4.setPersonId("004");
		staff4.setTitle(Person.TITLE.Mrs);
		staff4.setForename("Alice");
		staff4.setSurname("Test");
		staff4.setAddress1("24 Deansgate");
		staff4.setAddress2("");
		staff4.setAddress3("Cumbria");
		staff4.setTown("Manchester");
		staff4.setPostcode("M3 3NW");
		staff4.setMobilenumber("");
		staff4.setTelephonenumber("01611239000");
		allStaff.add(staff4);
					
		staffResp.save(allStaff);
		
		System.out.println("Staff added :" + allStaff.size());
	}
}