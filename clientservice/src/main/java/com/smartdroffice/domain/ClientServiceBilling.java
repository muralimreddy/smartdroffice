package com.smartdroffice.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="CLIENT_SERVICE_BILLING")
public class ClientServiceBilling implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="BILLING_ID")
	private BigInteger billingId;
	
	@Column(name="CLIENT_ID")
	private BigInteger clientId;
	
	@Column(name="PATIENT_ID")
	private BigInteger patientId;

	@Column(name="BILLING_DATE")
	private Date billingDate;
	
	@Column(name="PAYMENT_DURATION")
	private BigInteger paymentDur;
	
	@Column(name="CLIENT_BILLING_ID")
	private BigInteger clientBillingId;
	
	@Column(name="PAYMENT_DATE")
	private BigInteger paymentDate;
	
	@Column(name="PAID_AMT")
	private BigInteger paidAmt;
	
	@Column(name="BALANCE_AMT")
	private BigInteger balanceAmt;
	
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public BigInteger getBillingId() {
		return billingId;
	}

	public void setBillingId(BigInteger billingId) {
		this.billingId = billingId;
	}

	public BigInteger getClientId() {
		return clientId;
	}

	public void setClientId(BigInteger clientId) {
		this.clientId = clientId;
	}

	public BigInteger getPatientId() {
		return patientId;
	}

	public void setPatientId(BigInteger patientId) {
		this.patientId = patientId;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public BigInteger getPaymentDur() {
		return paymentDur;
	}

	public void setPaymentDur(BigInteger paymentDur) {
		this.paymentDur = paymentDur;
	}

	public BigInteger getClientBillingId() {
		return clientBillingId;
	}

	public void setClientBillingId(BigInteger clientBillingId) {
		this.clientBillingId = clientBillingId;
	}

	public BigInteger getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(BigInteger paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigInteger getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(BigInteger paidAmt) {
		this.paidAmt = paidAmt;
	}

	public BigInteger getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(BigInteger balanceAmt) {
		this.balanceAmt = balanceAmt;
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
