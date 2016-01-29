//Remote interface for providing Raffle results- mean and StdDev for output 
// in client side
package com.raffleinfo;

import javax.ejb.Remote;

@Remote
public interface RaffleServiceRemote {
	void setStdDev(double stdDev);
	void setMean(double mean);
	double getStdDev();
	double getMean();
	void RemoveRaffleServices();

}
