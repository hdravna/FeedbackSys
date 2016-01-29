package com.dbinterface;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//last used query for fetching a student record is stored in this table

@Entity
public class QueryTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int queryId;	

	private int studentId;
	
	private String lastUsedQuery;
	
	private String firstParameter;
	private String secondParameter;
	private String thirdParameter;
	private String fourthParameter;	
	
	public int getQueryId()
	{
		return queryId;
	}
	
	public void setQueryId(int id)
	{
		this.queryId = id;
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getLastUsedQuery() {
		return lastUsedQuery;
	}

	public void setLastUsedQuery(String lastUsedQuery) {
		this.lastUsedQuery = lastUsedQuery;
	}

	public String getFirstParameter() {
		return firstParameter;
	}

	public void setFirstParameter(String firstParameter) {
		this.firstParameter = firstParameter;
	}

	public String getSecondParameter() {
		return secondParameter;
	}

	public void setSecondParameter(String secondParameter) {
		this.secondParameter = secondParameter;
	}

	public String getThirdParameter() {
		return thirdParameter;
	}

	public void setThirdParameter(String thirdParameter) {
		this.thirdParameter = thirdParameter;
	}

	public String getFourthParameter() {
		return fourthParameter;
	}

	public void setFourthParameter(String fourthParameter) {
		this.fourthParameter = fourthParameter;
	}	
}
