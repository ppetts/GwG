package uk.org.getwellgamers.mapping;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

	@Autowired
	IDistanceController distanceService;

	@RequestMapping("/distance/{toPostcode}")
	public DistanceWrapper getStaff(@PathVariable String toPostcode) throws Exception {
		System.out.println("toPostcode = " + toPostcode);
		return distanceService.getClosestPerson(toPostcode);
	}
	
	@RequestMapping("/distance/{howMany}/{toPostcode}")
	public TreeSet<DistanceWrapper> getxStaff(@PathVariable int howMany, @PathVariable String toPostcode) throws Exception {
		System.out.println("toPostcode = " + toPostcode);
		return distanceService.getClosestPeople(howMany, toPostcode);
	}	
}