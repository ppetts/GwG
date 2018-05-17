package uk.org.getwellgamers.mapping;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import uk.org.getwellgamers.person.Person;
import uk.org.getwellgamers.staff.Staff;
import uk.org.getwellgamers.staff.StaffService;

//import com.google.maps.GeolocationApi.Response;


@Order(5)
@Component
public class Distance implements CommandLineRunner{

	@Autowired
	private StaffService staffservice;
	
	private static final Logger log = LoggerFactory.getLogger(Distance.class);
		
	public Person getClosestPerson(String toPostcode) {
		return getClosestPeople(1, toPostcode).first().person;
	}
	
	
	public TreeSet<DistanceWrapper> getClosestPeople(int howMany, String toPostcode) {
		
		//TODO Add URL Mapping?
		TreeSet<DistanceWrapper> distanceSet = new TreeSet<DistanceWrapper>();
		
		List<Staff> staffList = staffservice.getAllStaff();
		Staff thisStaff = null;
		
		for (int i = 0; i < staffList.size(); i++) {
			thisStaff = staffList.get(i);
			System.out.println("POSTCODE=" + thisStaff.getPostcode());
			
			double dist = getDistance(thisStaff.getPostcode(), toPostcode);
			
			DistanceWrapper distWrap = new DistanceWrapper(thisStaff, dist);
			distanceSet.add(distWrap);
		}
		
		return distanceSet;
	}
	

	public double getDistance(String pc1, String pc2) {
		
//		RestTemplate restTemplate = new RestTemplate();
//
//	//	System.setProperty("proxyHost", "yourproxy.server.com"); 
//	//	System.setProperty("proxyPort", "8080");
//				
//		String fooResourceUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=PR2%209HT&destinations=L403SF&mode=driving&language=GB&key=AIzaSyA03Gn1UI59XCq8ncK3sDixjI5XvM2mufs";
//		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//		// assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode root = mapper.readTree(response.getBody());
//		System.out.println(root.toString());
//
//		JsonNode name = root.path("destination_addresses");
//		System.out.println(name);
//
//
//
//
//		//	    Response response = restTemplate.getForObject("https://maps.googleapis.com/maps/api/distancematrix/json?origins=PR2%209HT&destinations=L403SF&mode=driving&language=GB&key=AIzaSyA03Gn1UI59XCq8ncK3sDixjI5XvM2mufs",Response.class);
//		log.info("==== RESTful API Response using Spring RESTTemplate START =======");
//		log.info(response.toString());
//		log.info("==== RESTful API Response using Spring RESTTemplate END =======");
//		//	    System.out.println("resp:" + response.getResult());
		
		
		
		return ThreadLocalRandom.current().nextDouble(0, 1000);
	}
	
	

	public void run(String... args) throws Exception {
		
		TreeSet<DistanceWrapper> results = getClosestPeople(2, "L40 3SF");
		
		DistanceWrapper firstDistWrapper = results.first();
		
	//	System.out.println("Closest:" + firstDistWrapper.person.getSurname() + "|distance:" + firstDistWrapper.distance);
		
		int count = 0;
		for (DistanceWrapper dw : results) {
			System.out.println(++count + ":" + dw.person.getSurname() + "|distance:" + dw.distance);
		}
		
						
		
		RestTemplate restTemplate = new RestTemplate();

	//	System.setProperty("proxyHost", "yourproxy.server.com"); 
	//	System.setProperty("proxyPort", "8080");
				
		String fooResourceUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=PR2%209HT&destinations=L403SF&mode=driving&language=GB&key=AIzaSyA03Gn1UI59XCq8ncK3sDixjI5XvM2mufs";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		// assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		System.out.println(root.toString());

		JsonNode name = root.path("destination_addresses");
		System.out.println(name);




		//	    Response response = restTemplate.getForObject("https://maps.googleapis.com/maps/api/distancematrix/json?origins=PR2%209HT&destinations=L403SF&mode=driving&language=GB&key=AIzaSyA03Gn1UI59XCq8ncK3sDixjI5XvM2mufs",Response.class);
		log.info("==== RESTful API Response using Spring RESTTemplate START =======");
		log.info(response.toString());
		log.info("==== RESTful API Response using Spring RESTTemplate END =======");
		//	    System.out.println("resp:" + response.getResult());
	}
}

