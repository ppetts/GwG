package uk.org.getwellgamers.hospital;

import javax.persistence.*;

@Entity
public class Hospital {
	
	@Id
	private String OrganisationID;
	private String OrganisationCode;
	private String OrganisationType;
	private String SubType;
	private String Sector;
	private String OrganisationStatus;	
	private boolean IsPimsManaged;
	private String OrganisationName;
	private String Address1;	
	private String Address2;	
	private String Address3;	
	private String City;
	private String County;	
	private String Postcode;
	private long Latitude;
	private long Longitude;
	private String ParentODSCode;
	private String ParentName;
	private String Phone;
	private String Email;
	private String Website;
	private String Fax;
	
	public Hospital() {
		super();
	}

	public String getOrganisationID() {
		return OrganisationID;
	}

	public void setOrganisationID(String organisationID) {
		OrganisationID = organisationID;
	}

	public String getOrganisationCode() {
		return OrganisationCode;
	}

	public void setOrganisationCode(String organisationCode) {
		OrganisationCode = organisationCode;
	}

	public String getOrganisationType() {
		return OrganisationType;
	}

	public void setOrganisationType(String organisationType) {
		OrganisationType = organisationType;
	}

	public String getSubType() {
		return SubType;
	}

	public void setSubType(String subType) {
		SubType = subType;
	}

	public String getSector() {
		return Sector;
	}

	public void setSector(String sector) {
		Sector = sector;
	}

	public String getOrganisationStatus() {
		return OrganisationStatus;
	}

	public void setOrganisationStatus(String organisationStatus) {
		OrganisationStatus = organisationStatus;
	}

	public boolean isIsPimsManaged() {
		return IsPimsManaged;
	}

	public void setIsPimsManaged(boolean isPimsManaged) {
		IsPimsManaged = isPimsManaged;
	}

	public String getOrganisationName() {
		return OrganisationName;
	}

	public void setOrganisationName(String organisationName) {
		OrganisationName = organisationName;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getAddress3() {
		return Address3;
	}

	public void setAddress3(String address3) {
		Address3 = address3;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCounty() {
		return County;
	}

	public void setCounty(String county) {
		County = county;
	}

	public String getPostcode() {
		return Postcode;
	}

	public void setPostcode(String postcode) {
		Postcode = postcode;
	}

	public long getLatitude() {
		return Latitude;
	}

	public void setLatitude(long latitude) {
		Latitude = latitude;
	}

	public long getLongitude() {
		return Longitude;
	}

	public void setLongitude(long longitude) {
		Longitude = longitude;
	}

	public String getParentODSCode() {
		return ParentODSCode;
	}

	public void setParentODSCode(String parentODSCode) {
		ParentODSCode = parentODSCode;
	}

	public String getParentName() {
		return ParentName;
	}

	public void setParentName(String parentName) {
		ParentName = parentName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

}