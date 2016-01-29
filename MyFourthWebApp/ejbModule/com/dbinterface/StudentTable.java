package com.dbinterface;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class StudentTable implements Serializable {

	/**
	 *	//This holds all the survey information and acts as a placeholder 
		//for a single Student survey data record fetched from DB.
		//Objects of this class are populated, collected and 
		//returned to client from Student Service Bean
 	 */
	private static final long serialVersionUID = 1L;
		
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
		private int studentId;	

		
		public int getStudentId()
		{
			return studentId;
		}
		
		public void setStudentId(int id)
		{
			this.studentId = id;
		}
		
		//@OneToMany(cascade={CascadeType.ALL},
				   //fetch = FetchType.EAGER)
		

		@OneToMany(fetch = FetchType.EAGER,
					cascade={CascadeType.ALL},				   
				   orphanRemoval=true)	
		@JoinTable(name="Student_Phone_Rel",
		joinColumns={@JoinColumn(name="studentId")},
		inverseJoinColumns={@JoinColumn(name="phoneID")})
		private Set<PhoneTable> phoneNumbers;
		

		public Set<PhoneTable> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(Set<PhoneTable> telephoneNums) {
			this.phoneNumbers = telephoneNums;
		}
		/*@OneToMany(cascade={CascadeType.ALL},
				   fetch = FetchType.EAGER)*/
		//@JoinColumn(name="studentId", referencedColumnName="studentId")
		
		//private Set<PhoneTable> phoneNumbers = new HashSet<PhoneTable>();
			
		//@Column(name="FirstName", length=50)
		private String firstName;
		
		//@Column(name="LastName", length=50)
		private String lastName;
		
		//@Column(name="Address", length=50)
		private String address;
		
		//@Column(name="City", length=50)
		private String city;
		
		//@Column(name="State", length=50)
		private String state;
		
		//@Column(name="Zip", length=50)
		private String zip;
		
		//@Column(name="Date", length=50)
		private String date;
		
		//@Column(name="Telephone", length=50)
		//private String telephone;
		
		//@Column(name="Email", length=50)
		private String email;
		
		//@Column(name="Raffle", length=50)
		private String raffle;
		
		//@Column(name="AddtionalInfo", length=50)
		private String additionalInfo;
		
		//@Column(name="Liking", length=50)
		private String userUnivPositivePoints;
		
		//@Column(name="HowInterest", length=50)
		private String userSourceOfInfo;
		
		//@Column(name="WillRecco", length=150)
		private String userReccommendUniv;

		private String emergencyName;
		
		private String emergencyPhone;
		
		private String emergencyEmail;
		
		public StudentTable()
		{ 
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

		public String getEmergencyName() {
			return emergencyName;
		}

		public void setEmergencyName(String emergencyName) {
			this.emergencyName = emergencyName;
		}

		public String getEmergencyPhone() {
			return emergencyPhone;
		}

		public void setEmergencyPhone(String emergencyPhone) {
			this.emergencyPhone = emergencyPhone;
		}

		public String getEmergencyEmail() {
			return emergencyEmail;
		}

		public void setEmergencyEmail(String emergencyEmail) {
			this.emergencyEmail = emergencyEmail;
		}
	}

