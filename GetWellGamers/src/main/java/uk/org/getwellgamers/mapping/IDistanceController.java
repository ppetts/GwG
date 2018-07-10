package uk.org.getwellgamers.mapping;

import java.util.TreeSet;

public interface IDistanceController {

	DistanceWrapper getClosestPerson(String toPostcode) throws Exception;
	TreeSet<DistanceWrapper> getClosestPeople(int howManyPeople, String toPostcode) throws Exception;

}