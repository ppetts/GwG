package uk.org.getwellgamers.staff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRep;

	public List<Staff> getAllStaff(){
		List<Staff> allStaff = new ArrayList<Staff>();
		staffRep.findAll().forEach(allStaff::add);
		return allStaff;
	}

	public Staff getStaff(StaffService staffService, String principalId, String forename, String surname) {
		
		Staff staff = this.getStaffbyPrincipalId(principalId);
		if(staff == null) {
			staff = this.getStaffbyName(forename, surname);
		}
		return staff;
	}
	
	
	public Staff getStaffbyPrincipalId(String principalId){
		System.out.println("Debug: getStaffbyPrincipalId : looking for " + principalId);
		List<Staff> staff = staffRep.findByPrincipalId(principalId);
		if(staff.size() == 0 ) {
			System.out.println("Debug: getStaffbyPrincipalId : Not found");
			return null;
		} else {
			System.out.println("Debug: getStaffbyPrincipalId : Found");
			return staff.get(0);
		}
	}
	
	public Staff getStaffbyName(String forename, String surname){
		System.out.println("Debug: getStaffbyName : looking for " + forename + "|" + surname);
		List<Staff> staff = staffRep.findByName(forename, surname);
		if(staff.size() == 0 ) {
			System.out.println("Debug: getStaffbyName : Not found");
			return null;
		} else {
			System.out.println("Debug: getStaffbyName : Found");
			return staff.get(0);
		}
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