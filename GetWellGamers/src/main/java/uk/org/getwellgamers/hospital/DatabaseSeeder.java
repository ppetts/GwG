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

		//TODO Read the CSV from gov website

		//Read this dynamically?  What if the site is down?
		//http://media.nhschoices.nhs.uk/data/foi/Hospital.csv
		//CSV might be saftest, can always redonload if required.  Fairly static data, & we have the option to manipulate
		Scanner scanner = new Scanner(new File("C:\\Users\\pettsp2\\Desktop\\TM470\\HospitalTab.csv"));
		//  scanner.useDelimiter("\t");
		while(scanner.hasNextLine()){

			String line = scanner.nextLine();
			String[] hospDetails = line.split("\t");

			System.out.println("Adding : " + hospDetails[7]);
			
			Hospital hosp = new Hospital();
			hosp.setOrganisationID(hospDetails[0]);
			hosp.setOrganisationCode(hospDetails[1]);
			hosp.setOrganisationType(hospDetails[2]);
			hosp.setSubType(hospDetails[3]);
			hosp.setSector(hospDetails[4]);
			hosp.setOrganisationStatus(hospDetails[5]);
			hosp.setIsPimsManaged(Boolean.getBoolean(hospDetails[6]));
			hosp.setOrganisationName(hospDetails[7]);
			hosp.setAddress1(hospDetails[8]);
			hosp.setAddress2(hospDetails[9]);
			hosp.setAddress3(hospDetails[10]);
			hosp.setCity(hospDetails[11]);
			hosp.setCounty(hospDetails[12]);
			hosp.setPostcode(hospDetails[13]);
//			hosp.setLatitude(Long.parseLong(hospDetails[14]));
//			hosp.setLongitude(Long.parseLong(hospDetails[15]));
			hosp.setParentODSCode(hospDetails[16]);
			hosp.setParentName(hospDetails[17]);
	//		hosp.setPhone(hospDetails[18]);
	//		hosp.setEmail(hospDetails[19]);
	//		hosp.setWebsite(hospDetails[20]);
	//		hosp.setFax(hospDetails[21]);
			Hospitals.add(hosp);		   
		}
		scanner.close();
		hospitalResp.save(Hospitals);

	}

}
