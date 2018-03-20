package uk.org.getwellgamers.hospital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepositry hospRep;

	public List<Hospital> getAllHospitals(){
		List<Hospital> allHosps = new ArrayList<Hospital>();
		hospRep.findAll().forEach(allHosps::add);
		return allHosps;
	}

	public Hospital getHospital(String id) {
		System.out.println("getHospital:" + id);
		return hospRep.findOne(id);
	}

	public void updateHospital(Hospital hosp) {
		hospRep.save(hosp);
	}

	public void deleteHospital(Hospital hosp) {
		hospRep.delete(hosp);
	}

	public void addHospital(Hospital hosp) {
		hospRep.save(hosp);
	}
}