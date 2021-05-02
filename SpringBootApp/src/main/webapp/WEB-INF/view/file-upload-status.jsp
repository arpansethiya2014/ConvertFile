<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="index.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload CSV file Status</title>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
      <div align="center">
      
      
      
      <c:choose>
    <c:when test="${status == true}">
        <h3> </h3>
        
        <h1>User Details</h1>
    <br>
    <table id="customers" border="1" cellpadding="10">
        <thead>
            <tr>
                <th> ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>CountryCode</th>
                <th>Age</th>
                
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.countryCode}</td>
                <td>${user.age}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
        
    </c:when>    
    <c:otherwise>
        <h3> <font color="red"> ${message}</font></h3>
        <br />
    </c:otherwise>
</c:choose>
      
    
</div>
</body>
</html>