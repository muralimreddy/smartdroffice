package com.smartdroffice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="INSURANCE")
public class Insurance implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="INS_ID")
	private BigInteger patientId;
	
	@Column(name="CLIENT_ID")
	private BigInteger clientId;
	
	@Column(name="MEMBER_ID")
	private String memberId;
	
	@Column(name="GROUP_ID")
	private String groupId;
	
	@Column(name="MEMBER_NAME")
	private String memberName;
	
	@Column(name="PLAN_TYPE")
	private String planType;
	
	@Column(name="CP_PCP")
	private BigDecimal coPayPrimaryCare;
	
	@Column(name="CP_SC")
	private BigDecimal coPaySpecialityCare;
	
	@Column(name="CP_EC")
	private BigDecimal coPayEmergencyCare;

	@Column(name="CP_UC")
	private BigDecimal coPayUrgentCare;
	
	@Column(name="PRESCRIPTION_GENERIC")
	private BigDecimal prescriptionGeneric;
	
	@Column(name="PRESCRIPTION_BRAND")
	private BigDecimal prescriptionBrand;
	
	@Column(name="PLAN_CONTACT")
	private String planContact;
	
	@Column(name="IN_NW_DEDUCTIBLE")
	private BigInteger inNetworkDeductible; 
	
	@Column(name="IN_NW_COINSURANCE")
	private BigInteger inNetworkCoinsurance;
	
	@Column(name="OUT_NW_DEDUCTIBLE")
	private BigInteger outOfNetworkDeductible; 
	
	@Column(name="OUT_NW_COINSURANCE")
	private BigInteger outOfNetworkCoinsurance;	
	
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public BigInteger getPatientId() {
		return patientId;
	}

	public void setPatientId(BigInteger patientId) {
		this.patientId = patientId;
	}

	public BigInteger getClientId() {
		return clientId;
	}

	public void setClientId(BigInteger clientId) {
		this.clientId = clientId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public BigDecimal getCoPayPrimaryCare() {
		return coPayPrimaryCare;
	}

	public void setCoPayPrimaryCare(BigDecimal coPayPrimaryCare) {
		this.coPayPrimaryCare = coPayPrimaryCare;
	}

	public BigDecimal getCoPaySpecialityCare() {
		return coPaySpecialityCare;
	}

	public void setCoPaySpecialityCare(BigDecimal coPaySpecialityCare) {
		this.coPaySpecialityCare = coPaySpecialityCare;
	}

	public BigDecimal getCoPayEmergencyCare() {
		return coPayEmergencyCare;
	}

	public void setCoPayEmergencyCare(BigDecimal coPayEmergencyCare) {
		this.coPayEmergencyCare = coPayEmergencyCare;
	}

	public BigDecimal getCoPayUrgentCare() {
		return coPayUrgentCare;
	}

	public void setCoPayUrgentCare(BigDecimal coPayUrgentCare) {
		this.coPayUrgentCare = coPayUrgentCare;
	}

	public BigDecimal getPrescriptionGeneric() {
		return prescriptionGeneric;
	}

	public void setPrescriptionGeneric(BigDecimal prescriptionGeneric) {
		this.prescriptionGeneric = prescriptionGeneric;
	}

	public BigDecimal getPrescriptionBrand() {
		return prescriptionBrand;
	}

	public void setPrescriptionBrand(BigDecimal prescriptionBrand) {
		this.prescriptionBrand = prescriptionBrand;
	}

	public String getPlanContact() {
		return planContact;
	}

	public void setPlanContact(String planContact) {
		this.planContact = planContact;
	}

	public BigInteger getInNetworkDeductible() {
		return inNetworkDeductible;
	}

	public void setInNetworkDeductible(BigInteger inNetworkDeductible) {
		this.inNetworkDeductible = inNetworkDeductible;
	}

	public BigInteger getInNetworkCoinsurance() {
		return inNetworkCoinsurance;
	}

	public void setInNetworkCoinsurance(BigInteger inNetworkCoinsurance) {
		this.inNetworkCoinsurance = inNetworkCoinsurance;
	}

	public BigInteger getOutOfNetworkDeductible() {
		return outOfNetworkDeductible;
	}

	public void setOutOfNetworkDeductible(BigInteger outOfNetworkDeductible) {
		this.outOfNetworkDeductible = outOfNetworkDeductible;
	}

	public BigInteger getOutOfNetworkCoinsurance() {
		return outOfNetworkCoinsurance;
	}

	public void setOutOfNetworkCoinsurance(BigInteger outOfNetworkCoinsurance) {
		this.outOfNetworkCoinsurance = outOfNetworkCoinsurance;
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
