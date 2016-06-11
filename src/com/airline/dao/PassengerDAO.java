package com.airline.dao;

import java.util.List;
import com.airline.model.Passenger;

public interface PassengerDAO {
	public void addPassenger (Passenger passenger);
	public void deletePassenger (Integer id);
	public void updatePassenger (Passenger passenger);
	public List<Passenger> getAllPassengers();
	public Passenger getPassenger (Integer id);
}
