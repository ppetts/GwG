package uk.org.getwellgamers.mapping;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import uk.org.getwellgamers.person.Person;
import uk.org.getwellgamers.staff.Staff;
import uk.org.getwellgamers.staff.StaffService;

//import com.google.maps.GeolocationApi.Response;


//@Order(5)
@Component
public class Distance {

	@Autowired
	private StaffService staffservice;
	
	public static final double METERS_IN_A_MILE = 1609.34;

	private static final Logger log = LoggerFactory.getLogger(Distance.class);

	public DistanceWrapper getClosestPerson(String toPostcode) throws Exception, Exception {
		Set<DistanceWrapper> ts = getClosestPeople(1, toPostcode);
		Iterator<DistanceWrapper> iter = ts.iterator();
		return iter.next();
	}


	public TreeSet<DistanceWrapper> getClosestPeople(int howMany, String toPostcode) throws Exception, IOException {

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

		TreeSet<DistanceWrapper> firstNElementsList = new TreeSet<DistanceWrapper>(); //(TreeSet<DistanceWrapper>) distanceSet.stream().limit(howMany).collect(Collectors.toSet());
		Iterator<DistanceWrapper> iter = distanceSet.iterator();
		
		int i=0;
		while(iter.hasNext() && i<howMany) {
			DistanceWrapper next = iter.next();
			firstNElementsList.add(next);
			i++;			
		}
				
		return firstNElementsList;
	}


	public double getDistance(String pc1, String pc2) throws JsonProcessingException, IOException {

		//TODO variable names
		//apiKey from Config
		//baseurl from config.

		RestTemplate restTemplate = new RestTemplate();

		String apiKey = "AIzaSyCtunvyfsw9jm4JV_6L4_dF_SXrDRGH12U";
		String fooResourceUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + pc1 + "&destinations=" + pc2 + "&mode=driving&language=GB&units=imperial&key=" + apiKey;
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
		//	assertThat(response.getStatusCode(), equals(HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());


		System.out.println(root.toString());

		JsonNode name = root.path("destination_addresses");
		System.out.println(name);
		log.info("==== RESTful API Response using Spring RESTTemplate START =======");
		log.info(response.toString());
		log.info("==== RESTful API Response using Spring RESTTemplate END =======");

		JsonNode rows = root.path("rows").get(0).path("elements").get(0).path("distance").get("value");

		//Covert to 2dp - precise enough.
		DecimalFormat df2 = new DecimalFormat(".##");
		return Double.parseDouble(df2.format(rows.asDouble() / METERS_IN_A_MILE)); 
	}
}

