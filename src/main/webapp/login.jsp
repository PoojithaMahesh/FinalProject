<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>
<form action="login" method="post">
Email:<input type="text" name="email">
Password:<input type="password" name="password"> 
<input type="submit" value="LOGIN">
</form>
</body>
</html>