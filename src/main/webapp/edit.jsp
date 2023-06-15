<%@page import="jspstudentA1.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
<%Student  student=(Student)request.getAttribute("student"); %>
<form action="edit" method="post">
ID:<input type="number" name="id" value="<%=student.getStudentId() %>" readonly="readonly">
<br>
<br>
Name:<input type="text" name="name" value="<%=student.getStudentName() %>" required="required">
<br>
<br>
Email:<input type="text" name="email" value="<%=student.getStudentEmail() %>" required="required">
<br>
<br>
Password:<input type="password" name="password" value="<%=student.getStudentPassword() %>" required="required">
<br>
<br>
Address:<input type="text" name="address" value="<%=student.getStudentAddress() %>" required="required">
<br>
<br>
PhoneNumaber:<input type="number" name="phone" value="<%=student.getStudentPhone() %>" required="required">
<br>
<br>
<input type="submit" value="Edit">




</form>
</body>
</html>