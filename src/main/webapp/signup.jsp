<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGNUP</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>
<form action="signup" method="post">
ID:<input type="number" name="id">
<br>
<br>
Name:<input type="text" name="name">
<br>
<br>
Email:<input type="text" name="email">
<br>
<br>
Password:<input type="password" name="password">
<br>
<br>
Address:<input type="text" name="address">
<br>
<br>
PhoneNumaber:<input type="number" name="phone">
<br>
<br>
<input type="submit" value="SIGNUP">
</form>
</body>
</html>