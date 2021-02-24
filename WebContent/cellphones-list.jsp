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
  border-collapse: collapse;
  width: 80%;
}
th, td {
  padding: 5px;
  border-collapse: collapse;
  border-bottom: 1px solid #ddd;
  background-color: #33CCFF;
  align: "center"";
}
th {
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
tfoot {
 border-bottom: none;
}
tr:hover {background-color:#f5f5f5;}
</style>
</head>
<body>
<br />
<br />
<br />

<form method = "post" action = "navigationServlet">
<table align="center">
<tr>
	<th>Update/Delete</th>
    <th>Manufacturer</th>
    <th>Model</th>
</tr>
<c:forEach items="${requestScope.allPhones}" var="currentitem">
<tr>
 <td><input type="radio" name="id" value="${currentitem.id}"></td>
 <td>${currentitem.manufacturer}</td>
 <td>${currentitem.model}</td>
 </tr>
</c:forEach>
<tfoot>
 <tr bgcolor ="#f5f5f5">
  <td style="text-align:center;"><input type = "submit" value = "edit" name="doThis"></td>
  <td style="text-align:center;"><input type = "submit" value = "delete" name="doThis"></td>
  <td style="text-align:center;"><input type="submit" value = "add" name = "doThis"></td>
 </tr>
</tfoot>
</table>

</form>

</body>
</html>