package uk.org.getwellgamers.staff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

	@Autowired
	private StaffRepositry staffRep;

	public List<Staff> getAllStaff(){
		List<Staff> allStaff = new ArrayList<Staff>();
		staffRep.findAll().forEach(allStaff::add);
		return allStaff;
	}

	public Staff getStaff(String id) {
		return staffRep.findOne(id);
	}

	public void updateStaff(Staff staff) {
		staffRep.save(staff);
	}

	public void deleteStaff(Staff hosp) {
		staffRep.delete(hosp);
	}

	public void addStaff(Staff hosp) {
		staffRep.save(hosp);
	}


}