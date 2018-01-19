package uk.org.getwellgamers.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

	@Autowired
	StaffService staffService;

	@RequestMapping("/staff")
	public List<Staff> getAllStaff() {
		return staffService.getAllStaff();
	}

	@RequestMapping("/staff/{id}")
	public Staff getStaff(@PathVariable String id) {
		return staffService.getStaff(id);
	}


	@RequestMapping(method=RequestMethod.POST, value="/staff/{id}")
	public Staff addStaff(@RequestBody Staff staff) {
		staffService.addStaff(staff);
		return staff;
	}


	@RequestMapping(method=RequestMethod.DELETE, value="/staff/{id}")
	public void deleteStaff(@RequestBody Staff staff) {
		staffService.deleteStaff(staff);
	}

}