<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Convert file Status</title>
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

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

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
				<h3>${message}</h3>
				<h4>
					<%-- <font color="blue"> <a href="${download}" download> Download MP4 File </a> </font> --%>
				</h4>
			</c:when>
			<c:otherwise>
				<h3>
					<font color="red">  ${message}</font>
				</h3>
			</c:otherwise>
		</c:choose>


	</div>
</body>
</html>