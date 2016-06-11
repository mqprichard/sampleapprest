<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Add New Passenger</title>
</head>
<body>
    <form action="PassengerController.do" method="post">
        <fieldset>
            <div>
                <label for="id">Passenger ID</label> <input type="text"
                    name="id" value="<c:out value="${passenger.id}" />"
                    readonly="readonly" placeholder="Passenger ID" />
            </div>
            <div>
                <label for="firstName">First Name</label> <input type="text"
                    name="firstName" value="<c:out value="${passenger.firstName}" />"
                    placeholder="First Name" />
            </div>
            <div>
                <label for="lastName">Last Name</label> <input type="text"
                    name="lastName" value="<c:out value="${passenger.lastName}" />"
                    placeholder="Last Name" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </fieldset>
    </form>
</body>
</html>