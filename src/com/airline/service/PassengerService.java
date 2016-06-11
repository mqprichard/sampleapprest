package com.airline.service;

import java.sql.ResultSet;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.airline.dao.PassengerDAOImplementation;
import com.airline.model.Passenger;
import com.google.gson.Gson;
import com.mysql.jdbc.ResultSetMetaData;

@Path("/PassengerService")
public class PassengerService {
	PassengerDAOImplementation dao = new PassengerDAOImplementation();
    
	@GET
	@Path("/passengers")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllPassengers() {
		Gson gson = new Gson();
		String jsonPassengerList = gson.toJson(dao.getAllPassengers());
		return jsonPassengerList;
	}
	
    @GET
    @Path(value="/slowrequest")
    public void slowRequest(@QueryParam(value="delay") int delay) throws Exception {
        for (int x = 0; x < delay; ++x) {
            Thread.sleep(1000);
        }
    }
    
    @GET
    @Path(value="/exception")
    public void throwException() throws Exception {
        throw new Exception("Forced Exception");
    }
    
    @GET
    @Path(value="/sqlexception")
    public void throwSqlException() throws Exception {
    	dao.throwSqlException();
    }
    
    @DELETE
    @Path(value="/deletepassenger/{id}")
    public String deletePassenger(@PathParam(value="id") Integer id) {
    	dao.deletePassenger(id);
    	return "Passenger deleted";
    }
    
    @PUT
    @Path(value="/put/{id}/{firstName}/{lastName}")
    public String updatePassenger(@PathParam(value="id") Integer id, @PathParam(value="firstName") String firstName, @PathParam(value="lastName") String lastName) {
    	Passenger updatedPassenger = dao.getPassenger(id);
    	updatedPassenger.setFirstName(firstName);
    	updatedPassenger.setLastName(lastName);
    	dao.updatePassenger(updatedPassenger);
    	return "Passenger updated";
    }
    
    @POST
    @Path(value="post/{id}/{firstName}/{lastName}")
    public String addPassenger(@PathParam(value="id") Integer id, @PathParam(value="firstName") String firstName, @PathParam(value="lastName") String lastName) {
    	Passenger newPassenger = new Passenger();
    	newPassenger.setId(id);
    	newPassenger.setFirstName(firstName);
    	newPassenger.setLastName(lastName);
    	dao.addPassenger(newPassenger);
		return "Passenger added";
    }
}