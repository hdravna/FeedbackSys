//Bean class for StudentServiceRemote. 
//Bussiness logic for saving data to DB, calculating mean, stdDev and storing the results in peer Bean RaffleService
// Business logic for retrieving all survey records till date present in DB

package com.dbinterface;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.dbinterface.PhoneTable;
import com.dbinterface.QueryTable;
import com.dbinterface.StudentTable;
import com.raffleinfo.RaffleServiceRemote;
import com.dbinterface.StudentDetails;
import com.dbinterface.StudentRemote;

/**
 * Session Bean implementation class StudentService
 */
@Stateless(mappedName="StudentService")

public class StudentService implements StudentServiceRemote {

	private static final String ERROR = "ERROR";
	private static final String SUCCESS = "SUCCESS";
	@Resource (mappedName="java:jboss/datasources/MysqlDS") DataSource ds;
	@PersistenceContext(unitName="MyFourthWebApp")  
    private EntityManager em;  
	ArrayList<StudentDetails> surveyDataTillDate;
	ArrayList<QueryTable> queryUsed; 
		
	/**
	 * @see Object#Object()
	 */
	public StudentService() {
			queryUsed = new ArrayList<QueryTable>();
	}

	@Override
	public String sendData(StudentRemote studentDetailsObj) {
		String status = "SUCCESS";
		try {
			Connection con = ds.getConnection();
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}
		
		StudentTable studentRecord = new StudentTable();
						
		studentRecord.setFirstName(studentDetailsObj.getFirstName());
		studentRecord.setLastName(studentDetailsObj.getLastName());
		studentRecord.setAdditionalInfo(studentDetailsObj.getAdditionalInfo());
		studentRecord.setAddress(studentDetailsObj.getAddress());
		studentRecord.setCity(studentDetailsObj.getCity());
		studentRecord.setDate(studentDetailsObj.getDate());
		studentRecord.setEmail(studentDetailsObj.getEmail());
		studentRecord.setRaffle(studentDetailsObj.getRaffle());
		studentRecord.setState(studentDetailsObj.getState());
		studentRecord.setUserReccommendUniv(studentDetailsObj.getUserReccommendUniv());
		studentRecord.setUserSourceOfInfo(studentDetailsObj.getUserSourceOfInfo());
		studentRecord.setUserUnivPositivePoints(studentDetailsObj.getUserUnivPositivePoints());
		studentRecord.setZip(studentDetailsObj.getZip());
		studentRecord.setEmergencyEmail(studentDetailsObj.getEmergencyEmail());
		studentRecord.setEmergencyName(studentDetailsObj.getEmergencyName());
		studentRecord.setEmergencyPhone(studentDetailsObj.getEmergencyPhone());

		Set<PhoneTable> phoneNumbers = new HashSet<PhoneTable>();
		
		phoneNumbers.add(new PhoneTable(studentDetailsObj.getPrimaryTelephone()));
		phoneNumbers.add(new PhoneTable(studentDetailsObj.getSecondaryTelephone()));
		studentRecord.setPhoneNumbers(phoneNumbers);
		
		try
		{			
			em.persist(studentRecord);			
		}
		
		catch(Exception e)
		{			
			e.printStackTrace();
		}		
		
		return status; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<StudentDetails> retrieveData() {
		try
		{
			String s = "SELECT s FROM " + StudentTable.class.getName() + " s";
			Query q = em.createQuery(s);		    
			surveyDataTillDate = (ArrayList<StudentDetails>) q.getResultList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return surveyDataTillDate;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<StudentDetails> deleteRecord(int studentId) {
		
		try
		{
			StudentTable student = em.find(StudentTable.class, studentId);
			if(student != null)
			{
				em.remove(student);
			}
			/*String s = "DELETE " + StudentTable.class.getName() + " s WHERE s.studentId = " + Id;
			Query q = em.createQuery(s);
			int result = q.executeUpdate();*/
			
			Query q = em.createQuery("from QueryTable q where q.studentId=:sId");
			q.setParameter("sId", studentId);
			queryUsed = (ArrayList<QueryTable>) q.getResultList();
			//QueryTable lastUsedQuery = em.find(QueryTable.class, studentId);
			QueryTable qt = queryUsed.get(queryUsed.size()-1);
			String s = qt.getLastUsedQuery();
			q = em.createQuery(s);		    
			
			if((qt.getFirstParameter()!= null) && !qt.getFirstParameter().isEmpty())
			q.setParameter(1, qt.getFirstParameter());
			
			if((qt.getSecondParameter()!= null) && !qt.getSecondParameter().isEmpty())
			q.setParameter(2, qt.getSecondParameter());
			
			if((qt.getThirdParameter()!= null) && !qt.getThirdParameter().isEmpty())
			q.setParameter(3, qt.getThirdParameter());
			
			if((qt.getFourthParameter()!= null) && !qt.getFourthParameter().isEmpty())
			q.setParameter(4, qt.getFourthParameter());
			
			surveyDataTillDate = (ArrayList<StudentDetails>) q.getResultList();	
			em.remove(qt);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return surveyDataTillDate;
	}
	@Override
	public String determineIfWinner(RaffleServiceRemote winningResultObj,
			StudentRemote studentActionObj) {
		String result="loser";

		if(studentActionObj != null && winningResultObj != null)
		{
			String raffleNumbers = studentActionObj.getRaffle();
			String[] str_numbers = raffleNumbers.split("\\s*,\\s*");
			ArrayList<Integer> Numbers = new ArrayList<Integer>(); 
			for(int i=0; i<str_numbers.length; i++)
			{
				int num = Integer.parseInt(str_numbers[i]);
				Numbers.add(num);			
			}

			double sum = 0.0;
			double average = 0.0;
			double std_dev = 0.0;

			for(int i=0; i<Numbers.size(); i++)
			{
				sum = sum + Numbers.get(i);			
			}
			average = sum/Numbers.size();

			double temp = 0;
			for(double a: Numbers)
			{
				temp += (average - a)*(average - a);
			}

			std_dev = Math.sqrt((temp/Numbers.size()));

			if(average > 90)
			{
				result = "winner";
			}

			winningResultObj.setStdDev(std_dev);
			winningResultObj.setMean(average);
		}
		return result;
	}
}
