package uk.org.getwellgamers.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

	@Autowired
	DistanceService distanceService;

	@RequestMapping("/distance/{toPostcode}")
	public DistanceWrapper getStaff(@PathVariable String toPostcode) throws Exception {
		System.out.println("toPostcode = " + toPostcode);
		return distanceService.getNearestStaff(toPostcode);
	}
}