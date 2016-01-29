//implementation class of StudentRemote interface
package com.dbinterface;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateless;

import com.dbinterface.PhoneTable;


/**
 * Session Bean implementation class Student
 */
@Stateless
@LocalBean
public class Student implements StudentRemote,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Default constructor. 
     */
	private StudentDetails studentObj;
    public Student() { 
        studentObj = new StudentDetails();
    }
    
    public StudentDetails getStudentDetails()
	{
		return studentObj;
	}
	
	public void setStudentDetails(StudentDetails student_obj)
	{
		studentObj = student_obj;
	}
	
	public String getFirstName()
	{
		return studentObj.getFirstName();
	}
	
	public void setFirstName(String firstName)
	{
		studentObj.setFirstName(firstName);
	}
	
	public String getLastName()
	{
		return studentObj.getLastName();
	}
	
	public void setLastName(String lastName)
	{
		studentObj.setLastName(lastName);
	}
	
	public String getAddress()
	{
		return studentObj.getAddress();
	}
	
	public void setAddress(String address)
	{
		studentObj.setAddress(address);
	}

	public String getCity() {
		return studentObj.getCity();
	}

	public void setCity(String city) {
		studentObj.setCity(city);
	}

	public String getState() {
		return studentObj.getState();
	}

	public void setState(String state) {
		studentObj.setState(state);
	}

	public String getZip() {
		return studentObj.getZip();
	}

	public void setZip(String zip) {
		studentObj.setZip(zip);
	}

	public String getDate() {
		return studentObj.getDate();
	}

	public void setDate(String date) {
		studentObj.setDate(date);
	}

	public String getUserUnivPositivePoints() {
		return studentObj.getUserUnivPositivePoints();
	}

	public void setUserUnivPositivePoints(String userUnivPositivePoints) {
		studentObj.setUserUnivPositivePoints(userUnivPositivePoints);
	}

	public String getUserSourceOfInfo() {
		return studentObj.getUserSourceOfInfo();
	}

	public void setUserSourceOfInfo(String userSourceOfInfo) {
		studentObj.setUserSourceOfInfo(userSourceOfInfo);
	}

	public String getUserReccommendUniv() {
		return studentObj.getUserReccommendUniv();
	}

	public void setUserReccommendUniv(String userReccommendUniv) {
		studentObj.setUserReccommendUniv(userReccommendUniv);
	}

	public String getRaffle() {
		return studentObj.getRaffle();
	}

	public void setRaffle(String raffle) {
		studentObj.setRaffle(raffle);
	}
	
	public String getAdditionalInfo() {
		return studentObj.getAdditionalInfo();
	}

	public void setAdditionalInfo(String additionalInfo) {
		studentObj.setAdditionalInfo(additionalInfo);
	}

	public String getEmail() {
		return studentObj.getEmail();
	}

	public void setEmail(String email) {
		studentObj.setEmail(email);
	}
	
	@Remove
	public void RemoveStudentObject()
	{
		studentObj.clear();
		studentObj = null;
	}

	@Override
	public void setPrimaryTelephone(String primaryTelephone) {
		studentObj.setPrimaryTelephone(new PhoneTable(primaryTelephone));		
	}
	
	@Override
	public void setSecondaryTelephone(String secondTelephone) {
		studentObj.setSecondaryTelephone(new PhoneTable(secondTelephone));		
	}

/*	@Override
	public void setAlternativeTelephone(String altTelephone) {
		studentObj.setAlternativeTelephone(new PhoneTable(altTelephone));		
	}*/

	@Override
	public String getPrimaryTelephone() {
		return studentObj.getPrimaryTelephone().getPhoneNumber();
	}

	@Override
	public String getSecondaryTelephone() {
		return studentObj.getSecondaryTelephone().getPhoneNumber();
	}

	@Override
	public int getStudentId() {
		return studentObj.getStudentId();
	}

	@Override
	public void setStudentId(int id) {
		studentObj.setStudentId(id);		
	}

	@Override
	public String getEmergencyName() {
		return studentObj.getEmergencyName();
	}

	@Override
	public String getEmergencyEmail() {
		return studentObj.getEmergencyEmail();
	}

	@Override
	public String getEmergencyPhone() {
		return studentObj.getEmergencyPhone();
	}

	@Override
	public void setEmergencyName(String emergencyName) {
		studentObj.setEmergencyName(emergencyName);
		
	}

	@Override
	public void setEmergencyEmail(String emergencyEmail) {
		studentObj.setEmergencyEmail(emergencyEmail);
	}

	@Override
	public void setEmergencyPhone(String emergencyPhone) {
		studentObj.setEmergencyPhone(emergencyPhone);
	}

	/*@Override
	public String getAlternativeTelephone() {
		return studentObj.getAlternativeTelephone().getPhoneNumber();
	}*/
}
