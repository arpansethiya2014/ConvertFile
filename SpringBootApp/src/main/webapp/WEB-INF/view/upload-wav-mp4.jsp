<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="index.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload CVS File</title>
<style type="text/css">
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 14px 28px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div align="center">
		<h2>Upload WAV File</h2>
		<br>
		<form method="POST" action="upload-mp4-file"  enctype="multipart/form-data" >
		    
			<input type="file" name="file"> <input type="submit"
				value="Upload" class="button"> 
		</form>
	</div>
</body>
</html>