<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

table {
  background-color: #33CCFF;
  border-collapse: collapse;
  width: 80%;
}
th, td {
  padding: 5px;
  border-collapse: collapse;
  }
  th {
  background-color: #4CAF50;
  color: white;
  }
</style>
</head>
<body>
<br />
<br />
<br />
<form action = "editPhoneServlet" method="post">
<table align="center">
<tr>
	<th colspan="2">Update Cellphone Information</th>
</tr>
<tr>
<td align="right">Manufacurer: </td> 
<td><input type ="text" name = "man" value="${phoneToEdit.manufacturer}"></td>
</tr>
<tr>
<td align="right">Model: </td>
<td><input type = "text" name = "mod" value= "${phoneToEdit.model}"></td>
</tr>
<tr>
<td><input type = "hidden" name = "id" value="${phoneToEdit.id}"></td>
<td><input type = "submit" value="Save Edited Item"></td>
</tr>
</table>
</form>

</body>
</html>