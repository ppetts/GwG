package uk.org.getwellgamers.mapping;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

	@Autowired
	private Distance distance;

	public DistanceWrapper getClosestPerson(String toPostcode) throws Exception {
		return distance.getClosestPerson(toPostcode);
	}
	
	public TreeSet<DistanceWrapper> getClosestPeople(int howManyPeople,String toPostcode) throws Exception {
		return (TreeSet<DistanceWrapper>) distance.getClosestPeople(howManyPeople, toPostcode);
	}
}