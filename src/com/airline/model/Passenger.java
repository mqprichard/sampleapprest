package com.airline.model;

public class Passenger {
	
	/*
	 * Passenger's fields
	 */
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	/*
	 * Passenger's constructor
	 */
	public Passenger() {}
	
	public Passenger(Integer id) {
		this.id = id;
	}
	
	/*
	 * Getters and setters
	 */
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	 * Auto-generated toString
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
