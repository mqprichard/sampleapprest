package com.airline.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.airline.dao.PassengerDAO;
import com.airline.dao.PassengerDAOImplementation;
import com.airline.model.Passenger;


/**
 * Servlet implementation class PassengerController
 */
@WebServlet("/PassengerController")
public class PassengerController extends HttpServlet {
	private PassengerDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_PASSENGERS = "/listPassengers.jsp";
	public static final String INSERT_OR_EDIT = "/passenger.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerController() {
    	dao = new PassengerDAOImplementation();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LIST_PASSENGERS;
            Integer id = Integer.parseInt( request.getParameter("id") );
            dao.deletePassenger(id);
            request.setAttribute("passengers", dao.getAllPassengers() );
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            Integer id = Integer.parseInt( request.getParameter("id") );
            Passenger passenger = dao.getPassenger(id);
            request.setAttribute("passenger", passenger);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = LIST_PASSENGERS;
            request.setAttribute("passengers", dao.getAllPassengers() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Passenger passenger = new Passenger();
        passenger.setFirstName( request.getParameter( "firstName" ) );
        passenger.setLastName( request.getParameter( "lastName" ) );
        String id = request.getParameter("id");
 
        if( id == null || id.isEmpty() )
            dao.addPassenger(passenger);
        else {
            passenger.setId( Integer.parseInt(id) );
            dao.updatePassenger(passenger);
        }
        RequestDispatcher view = request.getRequestDispatcher( LIST_PASSENGERS );
        request.setAttribute("passengers", dao.getAllPassengers());
        view.forward(request, response);
    }
}