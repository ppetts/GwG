package uk.org.getwellgamers.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

	@Autowired
	DistanceService distanceService;

	@RequestMapping("/distance/getnearest/{frompc}{topc}")
	public DistanceWrapper getStaff(@PathVariable String frompc, @PathVariable String topc) {
		return new DistanceWrapper(null, 0);
	}

//	@RequestMapping(method=RequestMethod.POST, value="/hospitalstaff/{id}")
//	public HospitalStaff addStaff(@RequestBody HospitalStaff staff) {
//		hospitalStaffService.addStaff(staff);
//		return staff;
//	}
//
//	@RequestMapping(method=RequestMethod.DELETE, value="/hospitalstaff/{id}")
//	public void deleteStaff(@RequestBody HospitalStaff staff) {
//		hospitalStaffService.deleteStaff(staff);
//	}
}