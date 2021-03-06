package uk.org.getwellgamers.person;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public abstract class Person {

	public enum TITLE{Mr, Mrs, Miss, Dr};
	public enum ROLE{ADMIN, AUTH_GOOGLE, AUTH_FACEBOOK};
		
	@Id
	private String personId;
	private TITLE title;
	private String forename;
	private String surname;
	private String mobilenumber;
	private String telephonenumber;
	private ArrayList<String> roles = new ArrayList<String>();
	
	
	
	public ArrayList<String> getRoles() {
		return roles;
	}
	
	public void addRole(String role) {
		this.roles.add(role);
	}
	
	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
	}
	
	public String getPersonId() {
		return personId;
	}
	
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	public TITLE getTitle() {
		return title;
	}
	public void setTitle(TITLE title) {
		this.title = title;
	}

	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}		
}