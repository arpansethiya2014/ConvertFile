<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<title>Convert</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  border: 1px solid #e7e7e7;
  background-color: #f3f3f3;
  width:35%;
}

li {
  float: left;
}

li a {
  display: block;
  color: #666;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #ddd;
}

li a.active {
  color: white;
  background-color: #4CAF50;
}
</style>
</head>
<body>
<div align="center">
<br>
<ul>
 <li><a class="active" href="#">Task</a></li>
  <li><a  href="/csvPage">Uplaod CSV</a></li>
  <li><a href="/wav2mp4Page">Convert MP4</a></li>
</ul>
<br>
<br>
   </div>   
</body>
</html>
