package uk.org.getwellgamers.hospital;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class HospitalDatabaseSeeder implements CommandLineRunner {

	//Generate the Donation Data for the Database 
	private HospitalRepositry hospitalResp;

	@Autowired
	public HospitalDatabaseSeeder(HospitalRepositry hospitalResp) {
		this.hospitalResp = hospitalResp;
	}

	@Override
	public void run(String... arg0) throws Exception {

		ArrayList<Hospital> Hospitals = new ArrayList<Hospital>();

		Scanner scanner = new Scanner(new File("C:\\Users\\pettsp2\\Desktop\\TM470\\HospitalDataClean.csv"));
		scanner.useDelimiter("\t");
		while(scanner.hasNextLine()){

			String line = scanner.nextLine();
			String[] hospDetails = line.split("\t");

			Hospital hosp = new Hospital();

			if(hospDetails.length < 22) {
				System.out.println("Not Adding : " + hospDetails[7] + " | " + hospDetails.length);

			} else {	

				//System.out.println("Adding " + hospDetails[7]);
				hosp.setOrganisationID(hospDetails[0].replace("\"", ""));
				hosp.setOrganisationCode(hospDetails[1]);
				hosp.setOrganisationType(hospDetails[2]);
				hosp.setSubType(hospDetails[3]);
				hosp.setSector(hospDetails[4]);
				hosp.setOrganisationStatus(hospDetails[5]);
				hosp.setIsPimsManaged(Boolean.getBoolean(hospDetails[6]));
				hosp.setOrganisationName(hospDetails[7].replace("\"", ""));
				hosp.setAddress1(hospDetails[8]);
				hosp.setAddress2(hospDetails[9]);
				hosp.setAddress3(hospDetails[10]);
				hosp.setCity(hospDetails[11]);
				hosp.setCounty(hospDetails[12]);
				hosp.setPostcode(hospDetails[13]);

				try {
					hosp.setLatitude(Double.parseDouble(hospDetails[14]));
					hosp.setLongitude(Double.parseDouble(hospDetails[15]));	
				} catch (Exception e) {
					System.out.println("No Lat / Long for " + hospDetails[7]);
				}

				hosp.setParentODSCode(hospDetails[16]);
				hosp.setParentName(hospDetails[17]);
				hosp.setPhone(hospDetails[18]);
				hosp.setEmail(hospDetails[19]);
				hosp.setWebsite(hospDetails[20]);
				hosp.setFax(hospDetails[21].replace("\"", ""));
				Hospitals.add(hosp);		  	
			}	 
		}
		scanner.close();
		hospitalResp.save(Hospitals);
		
		System.out.println("Hospitals added :" + Hospitals.size());
	}
}