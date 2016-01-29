package org.apache.struts.hw4.action;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.NamingException;
import javax.naming.Context;

import com.dbinterface.SearchSurvey;
import com.dbinterface.SearchSurveyRemote;
import com.dbinterface.StudentService;
import com.dbinterface.StudentServiceRemote;
import com.opensymphony.xwork2.ActionSupport;
import com.raffleinfo.RaffleService;
import com.raffleinfo.RaffleServiceRemote;
import com.studentinfo.Student;
import com.studentinfo.StudentDetails;
import com.studentinfo.StudentRemote;

public class ActionClass extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private StudentRemote studentActionObj;
	private RaffleServiceRemote winningResultObj;
	private StudentServiceRemote studentServiceObj;
	private SearchSurveyRemote searchSurveyObj;
	
	private ArrayList<StudentDetails> surveyDataTillDate;
	private ArrayList<String> univPositivePoints;
	private ArrayList<String> sourceOfInfo;
	private ArrayList<String> reccommendUniv;
	
    private Context context;
	public ActionClass()
	{
		final String appName = "MyFourthWebAppEAR";
		final String moduleName ="MyFourthWebApp";
		final String distinctName = "";
		final String studentbeanName = Student.class.getSimpleName();
		final String studentViewClassName = StudentRemote.class.getName();
		final String raffleServicebeanName = RaffleService.class.getSimpleName();
        final String raffleServiceViewClassName = RaffleServiceRemote.class.getName();
        final String studentServicebeanName = StudentService.class.getSimpleName();
        final String studentServiceViewClassName = StudentServiceRemote.class.getName();
        final String searchSurveybeanName = SearchSurvey.class.getSimpleName();
        final String searchSurveyRemote = SearchSurveyRemote.class.getName();
        
		Hashtable jndiProps = new Hashtable();
		jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		try {
			context = new javax.naming.InitialContext(jndiProps);
			studentActionObj = (StudentRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + 
					distinctName + "/" + studentbeanName + "!" + 
					studentViewClassName+"?stateful");
			
			 
			winningResultObj = (RaffleServiceRemote)context.lookup("ejb:" + appName + "/" + moduleName + "/" + 
					   distinctName + "/" + raffleServicebeanName + "!" + 
					   raffleServiceViewClassName+"?stateful");
			
			studentServiceObj = (StudentServiceRemote)context.lookup("ejb:" + appName + "/" + moduleName + "/" + 
						distinctName + "/" + studentServicebeanName + "!" + 
						studentServiceViewClassName);
			
			searchSurveyObj = (SearchSurveyRemote)context.lookup("ejb:" +appName + "/"+ moduleName + "/" +
						distinctName + "/" + searchSurveybeanName + "!"+searchSurveyRemote+ "?stateful");	
		}
		catch (NamingException e) {
			e.printStackTrace();
		}
		 univPositivePoints = new ArrayList<String>();
		 univPositivePoints.add("Students");
		 univPositivePoints.add("Campus");
		 univPositivePoints.add("Atmosphere");
		 univPositivePoints.add("Location");
		 univPositivePoints.add("Dorms");
		 univPositivePoints.add("Sports");

		 sourceOfInfo = new ArrayList<String>();
		 sourceOfInfo.add("Friends");
		 sourceOfInfo.add("TV");
		 sourceOfInfo.add("Internet");
		 sourceOfInfo.add("Other");

		 reccommendUniv = new ArrayList<String>();
		 reccommendUniv.add("Very Likely");
		 reccommendUniv.add("Likely");
		 reccommendUniv.add("Unlikely");		 
	}

	public ArrayList<StudentDetails> getSurveyDataTillDate()
	{
		return surveyDataTillDate;
	}

	public void setSurveyDataTillDate(ArrayList<StudentDetails> surveyDataTillDate)
	{
		this.surveyDataTillDate = surveyDataTillDate;
	}

	public ArrayList<String> getReccommendUniv()
	{
		return reccommendUniv;
	}

	public void setReccommendUniv(ArrayList<String> reccoUniv)
	{
		reccommendUniv.clear();
		reccommendUniv.addAll(reccoUniv);
	}

	public ArrayList<String> getSourceOfInfo()
	{
		return sourceOfInfo;
	}

	public void setSourceOfInfo(ArrayList<String> srcOfInfo)
	{
		sourceOfInfo.clear();
		sourceOfInfo.addAll(srcOfInfo);
	}

	public ArrayList<String> getUnivPositivePoints()
	{
		return univPositivePoints;
	}

	public void setUnivPositivePoints(ArrayList<String> univPosPnts)
	{
		univPositivePoints.clear();
		univPositivePoints.addAll(univPosPnts);
	}

	public String execute() throws Exception
	{		
		return SUCCESS;
	}

	public void validate()
	{
			if(studentActionObj != null)
			{
				if(studentActionObj.getFirstName().length() == 0)
				{
					addFieldError("studentActionObj.firstName", "First name is required");
				}

				if(studentActionObj.getLastName().length() == 0)
				{
					addFieldError("studentActionObj.lastName", "Last name is required");
				}

				if(studentActionObj.getAddress().length() == 0)
				{
					addFieldError("studentActionObj.address", "Address is required");
				}

				if(studentActionObj.getCity().length() == 0)
				{
					addFieldError("studentActionObj.city", "City name is required");
				}

				if(studentActionObj.getState().length() == 0)
				{
					addFieldError("studentActionObj.state", "State is required");
				}

				if(studentActionObj.getZip().length() == 0)
				{
					addFieldError("studentActionObj.zip", "Zip code is required");
				}

				if(studentActionObj.getPrimaryTelephone() == null)
				{
					addFieldError("studentActionObj.telephone", "Primary Number is required");
				}

				if(studentActionObj.getEmail().length() == 0)
				{
					addFieldError("studentActionObj.email", "Email id is required");
				}

				if(studentActionObj.getDate().length() == 0)
				{
					addFieldError("studentActionObj.date", "Date is required");
				}

				boolean is_raffle_input_ok_b = true;
				String[] str_numbers = studentActionObj.getRaffle().split("\\s*,\\s*");
				if (str_numbers.length != 10)
				{
					addFieldError("studentActionObj.raffle", "Please enter all/only 10 Raffle numbers");
				}
				ArrayList<Integer> Numbers = new ArrayList<Integer>();
				if(str_numbers.length == 10)
				{
					for(int i=0; i<str_numbers.length; i++)
					{
						int num = 0;
						try
						{
							num = Integer.parseInt(str_numbers[i]);
						}
						catch(NumberFormatException e)
						{
							is_raffle_input_ok_b = false;
						}

						if(num > 100)
						{
							is_raffle_input_ok_b = false;
						}
						else
						{
							Numbers.add(num);
						}			
					}
				}
				if(!is_raffle_input_ok_b)
				{
					addFieldError("studentActionObj.raffle", "raffle numbers should be between 0 and 100 seperated by commas");
				}
			}
}
	
	public String saveSurveyData()
	{		
		String result=SUCCESS;
		try
		{
			studentServiceObj.sendData(studentActionObj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result = studentServiceObj.determineIfWinner(winningResultObj, studentActionObj);
		return result;		
	}
	
	public String retrieveSurveyData()
	{
		String result = SUCCESS;
		surveyDataTillDate = new ArrayList <StudentDetails>();
		surveyDataTillDate = studentServiceObj.retrieveData();
		if(surveyDataTillDate == null)
		{
			result = ERROR;
		}
		//studentActionObj.RemoveStudentObject();
		//winningResultObj.RemoveRaffleServices();
		return result;
	}
	
	public String searchSurvey()
	{
		String result = SUCCESS;
		surveyDataTillDate = new ArrayList <StudentDetails>();
		surveyDataTillDate = searchSurveyObj.searchSurveyData(studentActionObj);
		if(surveyDataTillDate == null || surveyDataTillDate.isEmpty())
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

	public RaffleServiceRemote getWinningResultObj() {
		return winningResultObj;
	}

	public void setWinningResultObj(RaffleServiceRemote winningResultObj) {
		this.winningResultObj = winningResultObj;
	}

	public SearchSurveyRemote getSearchSurveyObj() {
		return searchSurveyObj;
	}

	public void setSearchSurveyObj(SearchSurveyRemote searchSurveyObj) {
		this.searchSurveyObj = searchSurveyObj;
	}

	/*public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}*/
}

