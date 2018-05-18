package uk.org.getwellgamers.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

	@Autowired
	private Distance distance;

	public DistanceWrapper getNearestStaff(String toPostcode) throws Exception {
		System.out.println("getHospital:" + toPostcode);
		return distance.getClosestPerson(toPostcode);
	}
}