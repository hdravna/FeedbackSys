// Implementation of RaffleServiceRemote interface.
// Stores calculated mean and StdDev.
// Bean instance created by Client and passed to peer bean Student Service while determining 
// if user is a winner based on raffle numbers. Student service bean uses the same instance
// to store the stdDev and mean results after calculating them
package com.raffleinfo;

import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class RaffleService
 */
@Stateful
@LocalBean
public class RaffleService implements RaffleServiceRemote {

	private double mean;
	private double stdDev;

    /**
     * Default constructor. 
     */
    public RaffleService() { }
	@Override
	public void setStdDev(double stdDev) {
		this.stdDev = stdDev;
	}

	@Override
	public void setMean(double mean) {
		this.mean = mean;		
	}

	public double getStdDev()
	{
		return stdDev;
	}
	
	public double getMean()
	{
		return mean;
	}
	
	@Remove
	public void RemoveRaffleServices()
	{
		mean = 0;
		stdDev = 0;
	}

    

}
