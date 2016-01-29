/* One to Many Unidirectional. No reference of student Object.
// One Student has many phones numbers 
*/

package com.dbinterface;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhoneTable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public PhoneTable() {}
	
	public PhoneTable(String phoneNum){
		this.phoneNumber = phoneNum;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int phoneID;	
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="studentId", referencedColumnName="studentId",nullable=false)
	//private StudentTable studentTable;	

/*
	public StudentTable getStudentTable()
	{
		return studentTable;
	}
	
	public void setStudentTable(StudentTable st)
	{
		this.studentTable = st;
	}
	*/
	//@Column(name="phoneNumber", length=50)
	private String phoneNumber;
	
	@JoinColumn(name="studentId")	
	private int studentId;
	
	public void setStudentId(int id)
	{
		this.studentId = id;
	}
	
	public int getStudentId()
	{
		return studentId;
	}
	
	
	public int getPhoneID()
	{
		return phoneID;
	}
	
	public void setPhoneID(int phoneID)
	{
		this.phoneID = phoneID;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
