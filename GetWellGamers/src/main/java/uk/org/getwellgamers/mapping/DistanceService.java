package uk.org.getwellgamers.mapping;

import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceService implements IDistanceController {

	@Autowired
	private Distance distance;

	/* (non-Javadoc)
	 * @see uk.org.getwellgamers.mapping.IDistanceController#getClosestPerson(java.lang.String)
	 */
	@Override
	public DistanceWrapper getClosestPerson(String toPostcode) throws Exception {
		return distance.getClosestPerson(toPostcode);
	}
	
	/* (non-Javadoc)
	 * @see uk.org.getwellgamers.mapping.IDistanceController#getClosestPeople(int, java.lang.String)
	 */
	@Override
	public TreeSet<DistanceWrapper> getClosestPeople(int howManyPeople,String toPostcode) throws Exception {
		return (TreeSet<DistanceWrapper>) distance.getClosestPeople(howManyPeople, toPostcode);
	}
}