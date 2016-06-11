<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Passengers</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Passenger ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${passengers}" var="passenger">
                <tr>
                    <td><c:out value="${passenger.id}" /></td>
                    <td><c:out value="${passenger.firstName}" /></td>
                    <td><c:out value="${passenger.lastName}" /></td>
                    <td><a
                        href="PassengerController.do?action=edit&id=<c:out value="${passenger.id }"/>">Update</a></td>
                    <td><a
                        href="PassengerController.do?action=delete&id=<c:out value="${passenger.id }"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="PassengerController.do?action=insert">Add Passenger</a>
    </p>
</body>
</html>