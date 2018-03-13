package uk.org.getwellgamers.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DatabaseSeeder implements CommandLineRunner {
	
	private HospitalRepositry hospitalResp;
	
	@Autowired
	public DatabaseSeeder(HospitalRepositry hospitalResp) {
		this.hospitalResp = hospitalResp;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		Hospital hosp = new Hospital();
		hosp.setName("Ormskirk");
		hosp.setAddress1("TODO");
		
		hospitalResp.save(hosp);
		
		
		hosp.setName("Addenbrooke's Hospital");
		hospitalResp.save(hosp);
		
	}

}
