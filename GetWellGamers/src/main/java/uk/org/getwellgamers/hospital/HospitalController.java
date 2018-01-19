package uk.org.getwellgamers.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

	@Autowired
	HospitalService hospitalService;

	@RequestMapping("/hospitals")
	public List<Hospital> getAllHosptials() {
		return hospitalService.getAllHospitals();
	}

	@RequestMapping("/hospitals/{id}")
	public Hospital getHospital(@PathVariable String id) {
		return hospitalService.getHospital(id);
	}


	@RequestMapping(method=RequestMethod.POST, value="/hospitals/{id}")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		hospitalService.addHospital(hospital);
		return hospital;
	}


	@RequestMapping(method=RequestMethod.DELETE, value="/hospitals/{id}")
	public void deleteHospital(@RequestBody Hospital hospital) {
		hospitalService.deleteHospital(hospital);
	}

}