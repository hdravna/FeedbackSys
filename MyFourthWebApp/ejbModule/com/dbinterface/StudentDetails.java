package com.dbinterface;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;

import com.dbinterface.PhoneTable;

public class StudentDetails implements Serializable {
	//This holds all the survey information and acts as a placeholder 
	//for a single Student survey data record fetched from DB.
	//Objects of this class are populated, collected and returned to client from Student Service Bean


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int studentId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String date;
	private String emergencyName;	
	private String emergencyPhone;	
	private String emergencyEmail;
	private PhoneTable primaryTelephone;
	private PhoneTable secondaryTelephone;
	private PhoneTable alternativeTelephone;
	private Set<PhoneTable> phoneNumbers;
	private String email;
	private String raffle;
	private String additionalInfo;

	private String userUnivPositivePoints;
	private String userSourceOfInfo;
	private String userReccommendUniv;
	private String query;

	public StudentDetails()
	{ 
	}
	
	public void clear()
	{
		firstName =null;
		lastName=null;
		address=null;
		city=null;
		state=null;
		zip=null;
		date=null;
		primaryTelephone=null;
		secondaryTelephone = null;
		alternativeTelephone = null;		
		email=null;
		raffle=null;
		additionalInfo=null;
		userUnivPositivePoints=null;
		userSourceOfInfo=null;
		userReccommendUniv=null;
	}
	
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserUnivPositivePoints() {
		return userUnivPositivePoints;
	}

	public void setUserUnivPositivePoints(String userUnivPositivePoints) {
		this.userUnivPositivePoints = userUnivPositivePoints;
	}

	public String getUserSourceOfInfo() {
		return userSourceOfInfo;
	}

	public void setUserSourceOfInfo(String userSourceOfInfo) {
		this.userSourceOfInfo = userSourceOfInfo;
	}

	public String getUserReccommendUniv() {
		return userReccommendUniv;
	}

	public void setUserReccommendUniv(String userReccommendUniv) {
		this.userReccommendUniv = userReccommendUniv;
	}

	public String getRaffle() {
		return raffle;
	}

	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneTable getPrimaryTelephone() {
		return primaryTelephone;
	}

	public void setPrimaryTelephone(Object primaryTelephone) {
		this.primaryTelephone = (PhoneTable)primaryTelephone;
	}

	public PhoneTable getSecondaryTelephone() {
		return secondaryTelephone;
	}

	public void setSecondaryTelephone(Object secondaryTelephone) {
		this.secondaryTelephone = (PhoneTable)secondaryTelephone;
	}

	public PhoneTable getAlternativeTelephone() {
		return alternativeTelephone;
	}

	public void setAlternativeTelephone(Object alternativeTelephone) {
		this.alternativeTelephone = (PhoneTable)alternativeTelephone;
		setPhoneNumbers();
	}

	public Set<PhoneTable> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers()
	{
		phoneNumbers.add(primaryTelephone);
		phoneNumbers.add(secondaryTelephone);
		phoneNumbers.add(alternativeTelephone);		
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyEmail() {
		return emergencyEmail;
	}

	public void setEmergencyEmail(String emergencyEmail) {
		this.emergencyEmail = emergencyEmail;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}	
}

