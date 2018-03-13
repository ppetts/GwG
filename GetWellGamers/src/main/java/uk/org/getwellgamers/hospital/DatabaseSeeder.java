package uk.org.getwellgamers.hospital;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DatabaseSeeder implements CommandLineRunner {
	
	//Generate the Hospital Data for the Database 
	private HospitalRepositry hospitalResp;
	
	@Autowired
	public DatabaseSeeder(HospitalRepositry hospitalResp) {
		this.hospitalResp = hospitalResp;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		ArrayList<Hospital> Hospitals = new ArrayList<Hospital>();
		
		Hospital hosp = new Hospital();
		hosp.setName("Ormskirk");
		hosp.setAddress1("TODO");
		Hospitals.add(hosp);
		
		
		Hospital hosp2 = new Hospital();
		hosp2.setName("Addenbrooke's Hospital");
		Hospitals.add(hosp2);
	
		hospitalResp.save(Hospitals);
		
	}

}
