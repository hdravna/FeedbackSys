package com.dbinterface;

import java.sql.Connection;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
//import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.sql.DataSource;

import com.dbinterface.QueryTable;
import com.dbinterface.StudentTable;
//import com.dbinterface.StudentDetails;

/**
 * Session Bean implementation class SearchSurvey
 * Business logic for searching the database based on user queries.
 * Search supports wild-card (only *) and also supports exact matches
 */
@Stateless
@WebService
public class SearchSurvey implements SearchSurveyRemote {

	ArrayList<StudentTable> searchedData = new ArrayList<StudentTable>();
	List<StudentTable> searchResults = new ArrayList<StudentTable>();
	@Resource (mappedName="java:jboss/datasources/MysqlDS") DataSource ds;

	@PersistenceContext(unitName="MyFourthWebApp")  
	private EntityManager em;
	private String lastQueryUsed;
	private String requiredFirstName;
	private String requiredLastName;
	private String requiredCity;
	private String requiredState;
	
	private String firstParam = null;
	private String secondParam = null;
	private String thirdParam = null;
	private String fourthParam = null;
	
	
	private Query q = null;	
	/**
	 * Default constructor 
	 */
	public SearchSurvey() {}
	

	@SuppressWarnings("unchecked")
	@WebMethod(operationName = "searchSurveyData")
	public ArrayList<StudentTable> searchSurveyData(StudentDetails studentObj)
	{
		

		try {
			Connection con = ds.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		java.sql.PreparedStatement stmt=null;

		requiredFirstName = studentObj.getFirstName();
		requiredLastName = studentObj.getLastName();
		requiredCity = studentObj.getCity();
		requiredState = studentObj.getState();
				
		boolean firstnamePresent= false;
		boolean lastNameIsPresent= false;
		boolean cityIsPresent= false;
		boolean stateIsPresent= false;

		if(!requiredFirstName.isEmpty())
			firstnamePresent= true;

		if(!requiredLastName.isEmpty())
			lastNameIsPresent=true;

		if(!requiredCity.isEmpty())
			cityIsPresent = true;

		if(!requiredState.isEmpty())
			stateIsPresent = true;

		boolean allHaveWildcards = (requiredFirstName.contains("*")&&
				requiredLastName.contains("*") &&
				requiredCity.contains("*") &&
				requiredState.contains("*"));

		boolean noWildcards = (!requiredFirstName.contains("*")&&
				!requiredLastName.contains("*") &&
				!requiredCity.contains("*") &&
				!requiredState.contains("*"));

		boolean allCriteriaPresent = ((!requiredFirstName.isEmpty()) && 
				(!requiredLastName.isEmpty()) && 
				(!requiredCity.isEmpty()) && 
				(!requiredState.isEmpty()));

		boolean atleastOnewildcardPresent = (requiredFirstName.contains("*") ||
				requiredLastName.contains("*") ||
				requiredCity.contains("*") ||
				requiredState.contains("*")); 

		//String s = "SELECT s FROM " + StudentTable.class.getName() + " s";
		//"select * from survey_tbl2 where FirstName=? AND LastName=? AND City=? AND State=?"

		//if all 4 criteria are present and nothing have wildcard *  
		if(allCriteriaPresent && noWildcards)
		{				
			q = em.createQuery ("from StudentTable c where c.firstName= ?1 AND "
					+ "c.lastName=?2 AND c.city=?3 AND c.state=?4");
			q.setParameter(1, requiredFirstName);				
			q.setParameter(2, requiredLastName);
			q.setParameter(3, requiredCity);
			q.setParameter(4, requiredState);
						
			setLastQueryUsed("from StudentTable c where c.firstName= ?1 AND "
					+ "c.lastName=?2 AND c.city=?3 AND c.state=?4");
			firstParam = requiredFirstName;
			secondParam = requiredLastName;
			thirdParam = requiredCity;
			fourthParam = requiredState;
			
			searchedData = (ArrayList<StudentTable>) q.getResultList();
		}

		//all criteria present with 4 wild cards
		else if(allHaveWildcards && allCriteriaPresent)
		{
			q = em.createQuery("from StudentTable c where c.firstName LIKE ?1 "
					+ "AND c.lastName LIKE ?2 AND c.city LIKE ?3 AND c.state LIKE ?4");
			requiredFirstName = requiredFirstName.replace('*', ' ').trim()+"%";
			requiredLastName = requiredLastName.replace('*', ' ').trim()+"%";
			requiredCity = requiredCity.replace('*', ' ').trim()+"%";
			requiredState = requiredState.replace('*', ' ').trim()+"%";
			q.setParameter(1,Calendar, TemporalType.DATE);
			q.setParameter(1, requiredFirstName);
			q.setParameter(2, requiredLastName);
			q.setParameter(3, requiredCity);
			q.setParameter(4, requiredState);
			
			setLastQueryUsed("from StudentTable c where c.firstName LIKE ?1 "
					+ "AND c.lastName LIKE ?2 AND c.city LIKE ?3 AND c.state LIKE ?4");
			
			firstParam = requiredFirstName;
			secondParam = requiredLastName;
			thirdParam = requiredCity;
			fourthParam = requiredState;
			
			searchedData = (ArrayList<StudentTable>) q.getResultList();
		}

		else if(atleastOnewildcardPresent && allCriteriaPresent)
		{
			q = em.createQuery("from StudentTable c where c.firstName like ?1"
					+ " AND c.lastName=?2 AND c.city=?3 AND c.state=?4");
	
			setLastQueryUsed("from StudentTable c where c.firstName like ?1"
					+ " AND c.lastName=?2 AND c.city=?3 AND c.state=?4");
	
			if(requiredFirstName.contains("*"))
			{
			
					requiredFirstName = requiredFirstName.replace('*', ' ').trim()+"%";
					q.setParameter(1, requiredFirstName);
			}
			else
			{
					q.setParameter(1, requiredFirstName);
			}
			
			if(requiredLastName.contains("*"))
			{				
			
				requiredLastName = requiredLastName.replace('*', ' ').trim()+"%";
				q.setParameter(2, requiredLastName);
			}
			else
			{
				q.setParameter(2, requiredLastName);
			}
			
			if(requiredCity.contains("*"))
			{
			
				requiredCity = requiredCity.replace('*', ' ').trim()+"%";
				q.setParameter(3, requiredCity);
			}
			else
			{
				q.setParameter(3, requiredCity);
			}

			if(requiredState.contains("*"))
			{
			
				requiredState = requiredState.replace('*', ' ').trim()+"%";
				q.setParameter(4, requiredState);
			}
			else
			{
				q.setParameter(4, requiredState);
			}

			firstParam = requiredFirstName;
			secondParam = requiredLastName;
			thirdParam = requiredCity;
			fourthParam = requiredState;
			searchedData = (ArrayList<StudentTable>) q.getResultList();
		}

		else if(!allCriteriaPresent)
		{			
			q = null;
			if(firstnamePresent && !lastNameIsPresent && !cityIsPresent && !stateIsPresent)
			{					
				if(requiredFirstName.contains("*"))
				{
					q = em.createQuery("from StudentTable c where c.firstName like ?1");				
					requiredFirstName = requiredFirstName.replace('*', ' ').trim()+"%";
					q.setParameter(1, requiredFirstName);					
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.firstName like ?1");
				}
				else
				{
					q = em.createQuery("from StudentTable c where c.firstName=?1");
					q.setParameter(1, requiredFirstName);					
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.firstName=?1");
				}
				
			}
			
			if(!firstnamePresent && lastNameIsPresent && !cityIsPresent && !stateIsPresent)
			{
				if(requiredLastName.contains("*"))
				{
					q = em.createQuery("from StudentTable c where c.lastName like ?2");
					requiredLastName = requiredLastName.replace('*', ' ').trim()+ "%";					
					q.setParameter(2, requiredLastName);
					
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.lastName like ?2");
				}
				else
				{
					q = em.createQuery("from StudentTable c where c.lastName=?2");
					q.setParameter(2, requiredLastName);
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.lastName=?2");
				}
				
				
			}

			if(!firstnamePresent && !lastNameIsPresent && cityIsPresent && !stateIsPresent)
			{

				if(requiredCity.contains("*"))
				{
					q = em.createQuery("from StudentTable c where c.city like ?3");
					requiredCity= requiredCity.replace('*', ' ').trim()+ "%";
					q.setParameter(3, requiredCity);
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.city like ?3");
				}
				else
				{
					q = em.createQuery("from StudentTable c where c.city=?3");
					q.setParameter(3, requiredCity);
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.city=?3");
				}
				
			}
			if(!firstnamePresent && !lastNameIsPresent && !cityIsPresent && stateIsPresent)
			{

				if(requiredState.contains("*"))
				{
					q = em.createQuery("from StudentTable c where c.state like ?4");
					requiredState= requiredState.replace('*', ' ').trim()+ "%";
					q.setParameter(4, requiredState);
					
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.state like ?4");
				}
				else
				{
					q= em.createQuery("from StudentTable c where c.state=?4");
					q.setParameter(4, requiredState);
					
					searchedData = (ArrayList<StudentTable>) q.getResultList();
					setLastQueryUsed("from StudentTable c where c.state=?4");
				}
				
				
			}

			if(firstnamePresent && lastNameIsPresent && !cityIsPresent && !stateIsPresent)
			{
				q = em.createQuery("from StudentTable c where c.firstName=?1 AND "
						+ "c.lastName=?2");
				q.setParameter(1, requiredFirstName);
				q.setParameter(2, requiredLastName);
				
				searchedData = (ArrayList<StudentTable>) q.getResultList();
				setLastQueryUsed("from StudentTable c where c.firstName=?1 AND "
						+ "c.lastName=?2");
			}

			if(firstnamePresent && !lastNameIsPresent && !cityIsPresent && stateIsPresent)
			{
				q = em.createQuery("from StudentTable c where c.firstName=?1 AND c.state=?3");
				q.setParameter(1, requiredFirstName);
				q.setParameter(3, requiredState);
				
				searchedData = (ArrayList<StudentTable>) q.getResultList();
				setLastQueryUsed("from StudentTable c where c.firstName=?1 AND c.state=?3");
			}

			if(!firstnamePresent && lastNameIsPresent && cityIsPresent && !stateIsPresent)
			{
				q= em.createQuery("from StudentTable c where c.lastName=?2 AND c.city=?3");
				q.setParameter(2, requiredLastName);
				q.setParameter(3, requiredCity);
				
				searchedData = (ArrayList<StudentTable>) q.getResultList();
				setLastQueryUsed("from StudentTable c where c.lastName=?2 AND c.city=?3");
			}	

			if(firstnamePresent && lastNameIsPresent && cityIsPresent && !stateIsPresent)
			{
				q= em.createQuery("from StudentTable c where c.firstName=?1"
						+ " AND c.lastName=?2 AND c.city=?3");
				q.setParameter(1, requiredFirstName);
				q.setParameter(2, requiredLastName);
				q.setParameter(3,requiredCity);
				
				searchedData = (ArrayList<StudentTable>) q.getResultList();
				setLastQueryUsed("from StudentTable c where c.firstName=?1"
						+ " AND c.lastName=?2 AND c.city=?3");
			}

			if(q == null)
			{
				q = em.createQuery("from StudentTable c where c.firstName=?1 OR c.lastName=?2"
						+ " OR c.city=?3 OR c.state=?4");
				q.setParameter(1, requiredFirstName);
				q.setParameter(2, requiredLastName);
				q.setParameter(3,requiredCity);
				q.setParameter(4, requiredState);
				
				searchedData = (ArrayList<StudentTable>) q.getResultList();
				setLastQueryUsed("from StudentTable c where c.firstName=?1 OR c.lastName=?2"
						+ " OR c.city=?3 OR c.state=?4");
			}
			
			firstParam = requiredFirstName;
			secondParam = requiredLastName;
			thirdParam = requiredCity;
			fourthParam = requiredState;
			
		}
	
		try
		{
			searchResults = q.getResultList();
			for(int i=0; i<searchResults.size(); i++)
			{
				StudentTable studentRecord = searchResults.get(i); 
				int studentId = studentRecord.getStudentId();
				QueryTable query = new QueryTable();
				query.setStudentId(studentId);
				query.setLastUsedQuery(lastQueryUsed);
				query.setFirstParameter(firstParam);
				query.setSecondParameter(secondParam);
				query.setThirdParameter(thirdParam);
				query.setFourthParameter(fourthParam);			
				
				em.persist(query);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

		return searchedData;
	}

	public String getLastQueryUsed() {
		return lastQueryUsed;
	}

	public void setLastQueryUsed(String lastQueryUsed) {
		this.lastQueryUsed = lastQueryUsed;
	}
	
}
