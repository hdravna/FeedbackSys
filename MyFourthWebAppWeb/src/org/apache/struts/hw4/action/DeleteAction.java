package org.apache.struts.hw4.action;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;

import com.dbinterface.StudentService;
import com.dbinterface.StudentServiceRemote;
import com.opensymphony.xwork2.ActionSupport;
import com.studentinfo.StudentDetails;

public class DeleteAction extends ActionSupport{
	/**
	 * This class handles the delete action functionality.
	 * Deletes the student record from database 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<StudentDetails> searchResults;
	private int studentId;

	private Context context;
	private StudentServiceRemote studentServiceObj;
	
	public DeleteAction()
	{	
		final String appName = "MyFourthWebAppEAR";
		final String moduleName ="MyFourthWebApp";
		final String distinctName = "";
		final String studentServicebeanName = StudentService.class.getSimpleName();
		final String studentServiceViewClassName = StudentServiceRemote.class.getName();
	
		Hashtable jndiProps = new Hashtable();
		jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try {
			context = new javax.naming.InitialContext(jndiProps);
			studentServiceObj = (StudentServiceRemote)context.lookup("ejb:" + appName + "/" + moduleName + "/" + 
					distinctName + "/" + studentServicebeanName + "!" + 
					studentServiceViewClassName);
		}
		catch (NamingException e) {
			e.printStackTrace();
		}		
	}
	public String deleteRecord()
	{
		String result = SUCCESS;
		int id = this.getStudentId();
		if(id == 0)
		{
			id = 1;
		}
		searchResults = new ArrayList <StudentDetails>();
		searchResults = studentServiceObj.deleteRecord(id);		
		return result;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int id) {
		studentId = id;
	}
	public ArrayList<StudentDetails> getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(ArrayList<StudentDetails> searchResults) {
		this.searchResults = searchResults;
	}
}
