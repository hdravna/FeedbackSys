//Remote Interface exposing methods for interaction with database and 
//determining if the student is a winner based on raffle numbers
package com.dbinterface;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.raffleinfo.RaffleServiceRemote;
import com.dbinterface.StudentDetails;
import com.dbinterface.StudentRemote;

@Remote
public interface StudentServiceRemote {

public ArrayList<StudentDetails> retrieveData();
public String sendData(StudentRemote studentActionObj);
public ArrayList<StudentDetails> deleteRecord(int id);
public String determineIfWinner(RaffleServiceRemote winningResultObj,
		StudentRemote studentActionObj);
}
