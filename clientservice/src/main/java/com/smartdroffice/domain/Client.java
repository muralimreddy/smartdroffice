package com.smartdroffice.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="CLIENT")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="CLIENT_ID")
	private BigInteger clientId;
	
	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="NAME")
	private String name;

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PATIENT", 
			 joinColumns={ @JoinColumn(name="CLIENT_ID", referencedColumnName="CLIENT_ID") },
			 inverseJoinColumns = @JoinColumn(name = "PATIENT_ID"))
	public List<Patient> patients;
	
	@OneToMany
	@JoinTable(name="INSURANCE",
			 joinColumns={ @JoinColumn(name="CLIENT_ID", referencedColumnName="CLIENT_ID") },
			 inverseJoinColumns = @JoinColumn(name = "INS_ID"))
	public List<Insurance> insurances;	
	
	@OneToMany
	@JoinTable(name="CLIENT_BILLING",
			 joinColumns={ @JoinColumn(name="CLIENT_ID", referencedColumnName="CLIENT_ID") },
			 inverseJoinColumns = @JoinColumn(name = "BILLING_ID"))
	public List<ClientBilling> clientBillings;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="GENDER")
	private String gender;

	@Column(name="ADDRESS_1")
	private String address1;
	
	@Column(name="ADDRESS_2")
	private String address2;

	@Column(name="CITY")
	private String city;

	@Column(name="STATE")
	private String state;

	@Column(name="CELL_PHONE")
	private String cellPhone;
	
	@Column(name="HOME_PHONE")
	private String homePhone;
	
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public BigInteger getClientId() {
		return clientId;
	}
	
	public List<Patient> getPatients(){
		return patients;
	}
	
	public void setPatients(List<Patient> patients){
		this.patients = patients;
	}
	
	public List<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurance> insurances) {
		this.insurances = insurances;
	}

	public List<ClientBilling> getClientBillings() {
		return clientBillings;
	}

	public void setClientBillings(List<ClientBilling> clientBillings) {
		this.clientBillings = clientBillings;
	}

	public void setClientId(BigInteger clientId) {
		this.clientId = clientId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}	
	@PrePersist
	void createdOn(){
		this.createDate = this.updateDate = new Date();
	}
	
	@PreUpdate
	void updatedOn(){
		this.updateDate = new Date();
	}	
	
}
