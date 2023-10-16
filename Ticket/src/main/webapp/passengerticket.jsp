<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TICKET BOOKIING</title>
</head>    
<body>
<form action="Passengerservlet" method="post">
<table>

<tr><td>ID:</td> <td><input type="number"   name="ID"></td></tr>
<tr><td>User Name: </td><td><input type="text" name="name"></td></tr>
<tr><td>Starting: </td><td><input type="text" name="Starting"></td></tr>
<tr><td>destination: </td><td><input type="text" name="destination"></td></tr>
<tr><td></td><td>
       <button type="submit">Register</button>
</table>
</form>
</body>
</html>