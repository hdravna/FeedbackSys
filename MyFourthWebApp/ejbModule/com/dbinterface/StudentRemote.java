//Remote interface to collect all the Survey input data from client
package com.dbinterface;

import javax.ejb.Remote;

@Remote
public interface StudentRemote {

	public String getFirstName();
	public String getLastName();
	public String getAddress();
	public String getRaffle();
	public String getDate();
	public String getEmail();
	public String getPrimaryTelephone();
	public String getSecondaryTelephone();
	//public String getAlternativeTelephone();
	public String getZip();
	public String getCity();
	public String getState();
	public String getUserUnivPositivePoints();
	public String getUserSourceOfInfo();
	public String getUserReccommendUniv();
	public String getAdditionalInfo();
	public String getEmergencyName();
	public String getEmergencyEmail();
	public String getEmergencyPhone();
	public int getStudentId();
	public void setEmergencyName(String emergencyName);
	public void setEmergencyEmail(String emergencyEmail);
	public void setEmergencyPhone(String emergencyPhone);	
	public void setFirstName(String string);
	public void setLastName(String string);
	public void setAddress(String string);
	public void setCity(String string);
	public void setState(String string);
	public void setZip(String string);
	public void setPrimaryTelephone(String string);
	public void setSecondaryTelephone(String string);
	//public void setAlternativeTelephone(String string);
	public void setEmail(String string);
	public void setDate(String string);
	public void setUserUnivPositivePoints(String string);
	public void setUserSourceOfInfo(String string);
	public void setUserReccommendUniv(String string);
	public void setRaffle(String string);
	public void setAdditionalInfo(String string);
	public void setStudentId(int id);
	public StudentDetails getStudentDetails();
	public void setStudentDetails(StudentDetails stdudent_details);
	public void RemoveStudentObject();
}
