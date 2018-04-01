package uk.org.getwellgamers.hospitalstaff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalStaffController {

	@Autowired
	HospitalStaffService hospitalStaffService;

	@RequestMapping("/hospitalstaff")
	public List<HospitalStaff> getAllStaff() {
		return hospitalStaffService.getAllHospitalStaff();
	}

	@RequestMapping("/hospitalstaff/{id}")
	public HospitalStaff getStaff(@PathVariable String id) {
		return hospitalStaffService.getStaff(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/hospitalstaff/{id}")
	public HospitalStaff addStaff(@RequestBody HospitalStaff staff) {
		hospitalStaffService.addStaff(staff);
		return staff;
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/hospitalstaff/{id}")
	public void deleteStaff(@RequestBody HospitalStaff staff) {
		hospitalStaffService.deleteStaff(staff);
	}
}