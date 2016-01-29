//Action class for searching capabilities
package org.apache.struts.hw4.action;
	import java.util.ArrayList;
	import java.util.Hashtable;

	import javax.naming.NamingException;
	import javax.naming.Context;

	import com.dbinterface.SearchSurvey;
	import com.dbinterface.SearchSurveyRemote;
	import com.opensymphony.xwork2.ActionSupport;
	import com.studentinfo.Student;
	import com.studentinfo.StudentDetails;
	import com.studentinfo.StudentRemote;

	public class SearchAction extends ActionSupport{
		private static final long serialVersionUID = 1L;
		private StudentRemote studentActionObj;
		private SearchSurveyRemote searchSurveyObj;
		private ArrayList<StudentDetails> searchResults;
		
	    private Context context;
		public SearchAction()
		{
			final String appName = "MyFourthWebAppEAR";
			final String moduleName ="MyFourthWebApp";
			final String distinctName = "";
			final String studentbeanName = Student.class.getSimpleName();
			final String studentViewClassName = StudentRemote.class.getName();
	        final String searchSurveybeanName = SearchSurvey.class.getSimpleName();
	        final String searchSurveyRemote = SearchSurveyRemote.class.getName();
	        
			Hashtable jndiProps = new Hashtable();
			jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			try {
				context = new javax.naming.InitialContext(jndiProps);
				studentActionObj = (StudentRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + 
						distinctName + "/" + studentbeanName + "!" + 
						studentViewClassName+"?stateful");
				searchSurveyObj = (SearchSurveyRemote)context.lookup("ejb:" +appName + "/"+ moduleName + "/" +
							distinctName + "/" + searchSurveybeanName + "!"+searchSurveyRemote+ "?stateful");	
			}
			catch (NamingException e) {
				e.printStackTrace();
			}
		}

		public ArrayList<StudentDetails> getSearchResults()
		{
			return searchResults;
		}

		public void setSearchResults(ArrayList<StudentDetails> searchRes)
		{
			this.searchResults = searchRes;
		}

		public String execute() throws Exception
		{		
			return SUCCESS;
		}

		public String searchSurvey()
		{
			String result = SUCCESS;
			searchResults = new ArrayList <StudentDetails>();
			searchResults = searchSurveyObj.searchSurveyData(studentActionObj);
			if(searchResults == null || searchResults.isEmpty())
			{
				result = ERROR;
			}		
			return result;
		}

		public StudentRemote getStudentActionObj()
		{
			return studentActionObj;
		}
		
		public void setStudentActionObj(StudentRemote studentActionObj)
		{
			this.studentActionObj = studentActionObj;
		}

		public SearchSurveyRemote getSearchSurveyObj() {
			return searchSurveyObj;
		}

		public void setSearchSurveyObj(SearchSurveyRemote searchSurveyObj) {
			this.searchSurveyObj = searchSurveyObj;
		}
	}

