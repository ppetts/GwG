package uk.org.getwellgamers.mapping;

import uk.org.getwellgamers.person.Person;

public class DistanceWrapper implements Comparable {
	
	Person person;
	double distance;

	public DistanceWrapper(Person myPerson, double myDistance) {
		this.person = myPerson;
		this.distance = myDistance;
	}

	@Override
	public int compareTo(Object o) {
		return (int) (this.distance - ((DistanceWrapper) o).distance);
	}
}