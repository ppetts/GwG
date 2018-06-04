package uk.org.getwellgamers.mapping;

import uk.org.getwellgamers.person.Person;

public class DistanceWrapper implements Comparable<Object> {
	
	Person person;
	double distance;

	public DistanceWrapper(Person myPerson, double myDistance) {
		this.person = myPerson;
		this.distance = myDistance;
	}

	@Override
	public int compareTo(Object o) {
		return (int) (this.getDistance() - ((DistanceWrapper) o).getDistance());
	}
	
	@Override
	public String toString() {
		return this.person.toString();
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	
}