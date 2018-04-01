package uk.org.getwellgamers.hospitalstaff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalStaffService {

	@Autowired
	private HospitalStaffRepositry hospStaffRep;

	public List<HospitalStaff> getAllHospitalStaff(){
		List<HospitalStaff> allHospitalStaff = new ArrayList<HospitalStaff>();
		hospStaffRep.findAll().forEach(allHospitalStaff::add);
		return allHospitalStaff;
	}

	public HospitalStaff getStaff(String id) {
		return hospStaffRep.findOne(id);
	}

	public void updateStaff(HospitalStaff hospStaff) {
		hospStaffRep.save(hospStaff);
	}

	public void deleteStaff(HospitalStaff hospStaff) {
		hospStaffRep.delete(hospStaff);
	}

	public void addStaff(HospitalStaff hospStaff) {
		hospStaffRep.save(hospStaff);
	}
}