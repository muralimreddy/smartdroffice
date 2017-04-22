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

@Entity(name="APPOINTMENT")
public class Appointment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "APPOINTMENT_ID")
	private BigInteger appointmentId;
	
	@Column(name="CLIENT_ID")
	private BigInteger clientId;
	
	@Column(name="PATIENT_ID")
	private BigInteger patientId;
	
	@Column(name="ROOM_ID")
	private BigInteger roomId;
	
	@Column(name="DR_ID")
	private BigInteger doctorId;
	
	@Column(name="NURSE_ID")
	private BigInteger nurseid;
	
	@Column(name="START_DTTM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name="END_DTTM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public BigInteger getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
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

	public BigInteger getRoomId() {
		return roomId;
	}

	public void setRoomId(BigInteger roomId) {
		this.roomId = roomId;
	}

	public BigInteger getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(BigInteger doctorId) {
		this.doctorId = doctorId;
	}

	public BigInteger getNurseid() {
		return nurseid;
	}

	public void setNurseid(BigInteger nurseid) {
		this.nurseid = nurseid;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
