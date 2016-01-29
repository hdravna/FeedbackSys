package com.dbinterface;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.dbinterface.StudentDetails;
//import com.dbinterface.StudentRemote;

@Remote
public interface SearchSurveyRemote {

	public ArrayList<StudentTable> searchSurveyData(StudentDetails studentActionObj);
}
