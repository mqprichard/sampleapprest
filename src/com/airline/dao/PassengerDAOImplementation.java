package com.airline.dao;

import java.sql.*;
import java.util.*;
import com.airline.model.Passenger;
import com.airline.util.DBUtil;

public class PassengerDAOImplementation implements PassengerDAO {
	private Connection conn;
	
	public PassengerDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addPassenger(Passenger passenger) {
		try {
			String query = "insert into passengers (firstName, lastName) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, passenger.getFirstName());
			preparedStatement.setString(2, passenger.getLastName());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletePassenger(Integer id) {
		try {
			String query = "delete from passengers where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		try {
			String query = "update passengers set firstName=?, lastName=? where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, passenger.getFirstName());
			preparedStatement.setString(2, passenger.getLastName());
			preparedStatement.setInt(3, passenger.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	@Override
	public List<Passenger> getAllPassengers() {
		List<Passenger> passengers = new ArrayList<Passenger>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from passengers");
			while (resultSet.next()) {
				Passenger passenger = new Passenger();
				passenger.setId(resultSet.getInt("id"));
				passenger.setFirstName(resultSet.getString("firstName"));
				passenger.setLastName(resultSet.getString("lastName"));
				passengers.add(passenger);
			}
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passengers;
	}

	@Override
	public Passenger getPassenger(Integer id) {
		Passenger passenger = new Passenger();
		try {
			String query = "select * from passengers where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				passenger.setId(resultSet.getInt("id"));
				passenger.setFirstName(resultSet.getString("firstName"));
				passenger.setLastName(resultSet.getString("lastName"));
			}
			resultSet.close();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return passenger;
	}
	
	public void throwSqlException() {
		try {
			String query = "insert into faketable (firstName, lastName) values (?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
